package org.library.rest.api.common.repository;

public final class SearchHelper {

    public static final char ESCAPE_CHAR = '\\';

    public static String buildLikePattern(String searchTerm) {
        return buildLikePattern(searchTerm, true);
    }

    public static String buildLikePattern(String searchTerm, boolean wildcardAtBeginning) {
        searchTerm = searchTerm.toLowerCase();
        searchTerm = searchTerm.replace("\\", ESCAPE_CHAR + "\\");
        searchTerm = searchTerm.replace("[", ESCAPE_CHAR + "[");
        searchTerm = searchTerm.replace("_", ESCAPE_CHAR + "_");
        searchTerm = searchTerm.replace("%", ESCAPE_CHAR + "%");
        return (wildcardAtBeginning ? "%" : "") + searchTerm + "%";
    }

}
