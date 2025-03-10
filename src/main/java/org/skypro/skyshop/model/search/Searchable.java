package org.skypro.skyshop.model.search;

import java.util.Comparator;
import java.util.UUID;

public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    String getNameSearchable();

    default String getStringRepresentation(){
        return this.getNameSearchable()+" - "+this.getTypeContent();
    };

   UUID getId();/*{
        return UUID(java.util.UUID);
    }*/

    public static class ReverseStringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            if (Integer.compare(s1.length(),s2.length())!=0){
                return s2.compareTo(s1);
            }
            else
                return 0;
        }
    }

}
