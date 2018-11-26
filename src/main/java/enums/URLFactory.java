package enums;

public enum URLFactory {

    MAIN_PAGE_MOBILE("https://m.trendyol.com/Butik/Liste/Kadin"),
    MAIN_PAGE("https://trendyol.com/Butik/Liste/Kadin");

    public String link;

    URLFactory(String url) {

        this.link = url;

    }
}
