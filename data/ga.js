// Track external links and file downloads with Google Analytics
// Adapted from: http://www.blastam.com/blog/index.php/2013/03/how-to-track-downloads-in-google-analytics-v2/
$(document).ready(function() {
    // The file types whose downloads we want to track
    var filetypes = /\.(zip|rar|gz|tar|pdf|ps|doc.*|txt|xls.*|ppt.*|bib)$/i;
    
    // Figure out the base URL so we can redirect download links later
    var baseHref = '';
    if ($('base').attr('href') != undefined) {
        baseHref = $('base').attr('href');
    }

    // Add click behaviour to all links
    $('a').on('click', function(event) {
        var el = $(this);
        var href = (typeof(el.attr('href')) != 'undefined') ? el.attr('href') : "";
        
        if (!href.match(/^javascript:/i)) {
            var track = true;
            var elEv = [];
            var isThisDomain = href.match(document.domain.split('.').reverse()[1] + '.' + document.domain.split('.').reverse()[0]);
            
            if (href.match(filetypes)) {
                // A download link
                var extension = (/[.]/.exec(href)) ? /[^.]+$/.exec(href) : undefined;
                
                elEv.category = "download";
                elEv.action = "click-" + extension[0];
                elEv.label = href.replace(/ /g,"-");
                elEv.loc = baseHref + href;
            } else if (href.match(/^https?\:/i) && !isThisDomain) {
                // An external link
                elEv.category = "external";
                elEv.action = "click";
                elEv.label = href.replace(/^https?\:\/\//i, '');
                elEv.loc = href;
            } else {
                track = false;
            }

            if (track) {
                // Report the event to Google Analytics
                ga('send', 'event', elEv.category.toLowerCase(), elEv.action.toLowerCase(), elEv.label.toLowerCase());
                
                // If this is a link that opens in the same window, we need to wait a little while for the event to register
                if (event.which == 1 && (el.attr('target') == undefined || el.attr('target').toLowerCase() != '_blank')) {
                    setTimeout(function() { location.href = elEv.loc; }, 400);
                    return false;
                }
            }
        }
    });
    
    // Add event tracking behaviour to all toggle buttons
    $('.abstract-toggle').on('click', function() {
        ga('send', 'event', 'toggle', 'click-abstract', $(this).parent().attr('id').toLowerCase());
    });
    $('.bibtex-toggle').on('click', function() {
        ga('send', 'event', 'toggle', 'click-bibtex', $(this).parent().attr('id').toLowerCase());
    });
});

// Google analytics code
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

ga('create', '~GAUSERACCOUNT~', 'auto');
ga('send', 'pageview');
