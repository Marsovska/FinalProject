package utils;

import pages.CreatingLogCredentialsPage;

public class PageInitializer {

    public static CreatingLogCredentialsPage creatingLogCredentialsPage;

    public static void ACTIVATE_PAGE_OBJECTS() {

        creatingLogCredentialsPage = new CreatingLogCredentialsPage();
    }
}
