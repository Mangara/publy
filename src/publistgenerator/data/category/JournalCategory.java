/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package publistgenerator.data.category;

import publistgenerator.data.bibitem.BibItem;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class JournalCategory extends OutputCategory {

    public JournalCategory() {
        super("Journal", "Journal papers", CategoryIdentifier.JOURNAL);
    }

    @Override
    public boolean fitsCategory(BibItem item) {
        if ("article".equals(item.getType())) {
            if (item.anyNonEmpty("status") && !item.get("status").startsWith("accepted")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
