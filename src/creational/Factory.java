package creational;

import java.util.Locale;

public class Factory {
    public static void main(String[] args) {

        LanguageFactory indianLanguageFactory = new IndianLanguageFactory();
        LanguageFactory usLanguageFactory = new USLanguageFactory();

        Language languageSelected = switch (Locale.getDefault().getCountry()) {
            case "US" -> usLanguageFactory.getLanguage();
            case "IN" -> indianLanguageFactory.getLanguage();
            default -> throw new IllegalStateException("Unexpected value: " + Locale.getDefault().getCountry());
        };

        System.out.println(languageSelected.sayHello());
    }

}

interface Language {
    String sayHello();
}

class IndianLanguage implements Language {
    @Override
    public String sayHello() {
        return "Namaste";
    }
}

class USLanguage implements Language {

    @Override
    public String sayHello() {
        return "Hi";
    }
}

interface LanguageFactory {
    Language getLanguage();
}

class USLanguageFactory implements LanguageFactory {

    @Override
    public Language getLanguage() {
        return new USLanguage();
    }
}

class IndianLanguageFactory implements LanguageFactory {
    @Override
    public Language getLanguage() {
        return new IndianLanguage();
    }
}