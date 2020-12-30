package battleship;

public enum Message {
    WIN("You sank the last ship. You won. Congratulations!"),
    HIT("You hit a ship! Try again:"),
    MISS("You missed. Try again:"),
    SANK("You sank a ship! Specify a new target:"),
    ERROR("Error! You entered the wrong coordinates! Try again:"),
    START("The game starts!"),
    SHOT("Take a shot!");

    private String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
