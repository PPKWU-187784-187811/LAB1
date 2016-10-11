import java.util.Optional;

/**
 * Created by student on 27.09.2016.
 */
public interface Callback {
    Optional<String> getResult(InfoCallback infoCallback);
}
