/*
 * Copyright 2013-2015 Sander Verdonschot <sander.verdonschot at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package publy.io.html;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import publy.data.bibitem.BibItem;
import publy.data.bibitem.Type;
import publy.io.TestUtils;

public class HTMLBibItemWriterTest {

    public HTMLBibItemWriterTest() {
    }

    /**
     * Test of write method, of class HTMLBibItemWriter.
     */
    @Test
    public void testWrite() {
        System.out.println("write");

        for (Type type : Type.getEntryTypes()) {
            if (type == Type.ONLINE || type == Type.PATENT) {
                continue;
            }

            try (InputStream in = HTMLBibItemWriterTest.class.getResource(type + "_test.properties").openStream()) {
                Properties props = new Properties();
                props.load(in);
                HTMLTestUtils.testWithDefaultValues(type, props);
            } catch (IOException ex) {
                ex.printStackTrace();
                fail("IOException when reading properties file.");
            }
        }
    }

    @Test
    public void testWriteIgnore() {
        System.out.println("writeIgnore");

        for (Type type : Type.getEntryTypes()) {
            BibItem item = TestUtils.getFullBibItem(type);
            Set<String> mandatoryFields = TestUtils.getMandatoryFields(type);

            Set<String> optionalFields = new HashSet<>(item.getFields());
            optionalFields.removeAll(mandatoryFields);

            List<Set<String>> subsets = TestUtils.getAllSubsets(optionalFields);

            for (Set<String> set : subsets) {
                HTMLTestUtils.testIgnore(item, set);
            }
        }
    }
}