package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.reposotiry.GreetingRepository;

public class GreetingServiceFactory {

    private final GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "de":
                return new PrimaryGermanGreetingService(greetingRepository);
            case "es":
                return new PrimarySpanishGreetingService(greetingRepository);
            case "en":
            default:
                return new PrimaryGreetingService(greetingRepository);
        }
    }
}
