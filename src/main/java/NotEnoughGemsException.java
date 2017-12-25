public class NotEnoughGemsException extends Exception {
    public NotEnoughGemsException(Gem g) {
        super("Not enough " + g.toString() +" gems");
    }
}
