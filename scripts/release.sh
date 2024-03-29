#!/bin/bash

# Set constants
VERSION_FILE="src/publy/Constants.java"
CHANGELOG="CHANGELOG.md"
TEST_OUTPUT="test-output.tmp"
JAR_FILE="dist/Publy.jar"
PROJECT_DIR=${PWD##*/}


# Process parameters
while [[ $# -gt 0 ]]
do
    key="$1"

    case $key in
        --final)
            opt_final=TRUE
            shift # past argument
        ;;
        *)
                # unknown option
        ;;
    esac

    shift # past argument or value
done


# Get the version number from Constants.java
versionRegex="_VERSION ?= ?([0-9][0-9]*);"

codeMajorVersionLine="$(grep MAJOR_VERSION $VERSION_FILE)"
[[ $codeMajorVersionLine =~ $versionRegex ]]
codeMajorVersion="${BASH_REMATCH[1]}"

codeMinorVersionLine="$(grep MINOR_VERSION $VERSION_FILE)"
[[ $codeMinorVersionLine =~ $versionRegex ]]
codeMinorVersion="${BASH_REMATCH[1]}"

version="${codeMajorVersion}.${codeMinorVersion}"


# Verify that the change log has been updated
latestVersionChangeLine="$(grep --max-count=1 "## \[" $CHANGELOG)"

# Check that the version is correct
changelogVersionRegex="\[([0-9][0-9]*\.[0-9][0-9]*)\]"
[[ $latestVersionChangeLine =~ $changelogVersionRegex ]]
changelogVersion="${BASH_REMATCH[1]}"

if [ ! $changelogVersion = $version ]
then
    echo "ERROR: Latest change log version (${changelogVersion}) does not match current code version (${version})."
    exit 1
fi

# Check that the date is correct
# changelogDateRegex="([0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9])"
# [[ $latestVersionChangeLine =~ $changelogDateRegex ]]
# changelogDate="${BASH_REMATCH[1]}"

# if [[ -z $changelogDate ]]
# then
#     echo "ERROR: The change log does not specify a date for the latest version."
#     exit 1
# fi

# if [[ ! $changelogDate = "$(date +'%Y-%m-%d')" ]]
# then
#     echo "ERROR: Latest change log version date (${changelogDate}) does not match today's date ($(date +'%Y-%m-%d'))."
#     exit 1
# fi


# Clean and build the project
echo "Cleaning and building the project... "
ant -S -Dplatforms.JDK_1.8.home=$JAVA_HOME clean
ant -S -Dplatforms.JDK_1.8.home=$JAVA_HOME jar
echo "done."


# Verify that all tests are passing
echo "Verifying that all unit tests are passing... "
ant -Dplatforms.JDK_1.8.home=$JAVA_HOME -Dlibs.junit_4.classpath=/usr/share/java/junit4.jar test > "$TEST_OUTPUT" 2> "$TEST_OUTPUT"
if grep -Fq "FAILED" "$TEST_OUTPUT"
then
    echo "ERROR: Some tests failed. For details, see \"$TEST_OUTPUT\"."
    exit 1
else
    rm "$TEST_OUTPUT"
fi
echo "done."


# Make the .jar file executable
if [ ! -e "$JAR_FILE" ]
then
    echo "ERROR: Jar file $JAR_FILE is missing. Run a clean and build operation in NetBeans to generate this file."
    exit 1
fi

chmod +x "$JAR_FILE"


# Remove the old zip file
echo -n "Removing old zip file... "
rm Publy*.zip
echo "done."


# Create a new zip file
echo -n "Creating new zip file... "
ZIP_FILE="Publy $version.zip"
zip -q "$ZIP_FILE" "LICENSE" "NOTICE" "CHANGELOG.md" "publications.bib"
zip -qr "$ZIP_FILE" data lib # Recursively add these directories
zip -qj "$ZIP_FILE" "$JAR_FILE" # Add the jar file without directory information
if [ -e "data/PublySettings.xml" ]
then
    zip -qd "$ZIP_FILE" data/PublySettings.xml # Remove any existing settings file
fi
echo "done."


# Finalize release
if [ $opt_final ]
then
    # Commit these changes
    echo -n "Committing changes... "
    git add -u # Make sure git picks up removal of old zip file
    git add "$ZIP_FILE"
    git commit -m "Update release v$version zip"


    # Tag the current revision with the release number
    git tag -a "v$version" -m "Tag release v$version"
    echo "done."
fi
