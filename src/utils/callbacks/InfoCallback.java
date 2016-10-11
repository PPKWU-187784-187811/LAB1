package utils.callbacks;

import utils.Info;

import java.util.Optional;

/**
 * Created by Adam Piech on 2016-10-11.
 */

public interface InfoCallback {
    Optional<String> getResult(Info info);
}
