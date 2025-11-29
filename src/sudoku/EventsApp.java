package sudoku;

public class EventsApp {

    public static void main(String[] args) {

        Button button = new Button(new ButtonClickHandler());
        button.click();
        button.click();
        button.click();

        Button tvButton = new Button(new EventHandler() {

            private boolean on = false;

            public void execute() {

                if (on) {
                    System.out.println("TV is off");
                    on = false;
                } else {
                    System.out.println("TV is turn on");
                    on = true;
                }
            }
        });

        Button printButton = new Button(new EventHandler() {
            public void execute() {
                System.out.println("Started printing on printer...");
            }
        });

        tvButton.click();
        printButton.click();
        tvButton.click();
    }
}

class ButtonClickHandler implements EventHandler {

    public void execute() {

        System.out.println("Кнопка нажата!");
    }
}

interface EventHandler {

    void execute();
}

class Button {

    EventHandler handler;

    Button(EventHandler action) {

        this.handler = action;
    }

    public void click() {

        handler.execute();
    }
}