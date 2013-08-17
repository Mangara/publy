/*
 * Copyright 2013 Sander Verdonschot <sander.verdonschot at gmail.com>.
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
package publy.data.category;

import publy.data.bibitem.BibItem;

/**
 *
 * @author Sander Verdonschot <sander.verdonschot at gmail.com>
 */
public class ConferenceCategory extends OutputCategory {

    public ConferenceCategory() {
        super("Conference", "Conference papers", CategoryIdentifier.CONFERENCE);
    }

    @Override
    public boolean fitsCategory(BibItem item) {
        if ("inproceedings".equals(item.getType())) {
            return !item.anyNonEmpty("status") || item.get("status").startsWith("accepted");
        } else {
            return false;
        }
    }

}
