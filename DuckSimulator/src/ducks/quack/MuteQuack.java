package ducks.quack;

public class MuteQuack implements QuackBehaviour {
    @Override
    public String quack() {
        return "Silent no Quack";
    }
}
