package uk.co.leoaureum.testdriver.environment;

import java.util.List;

/**
 * Interface for dealing with multi-variate tests.
 */
public interface MvtHandler {

    /**
     * Return a list of all active MVTs.
     * @return the list of active MVTs.
     */
    List<String> getMvts();

    /**
     * Ensure the specified MVTs are active.
     * @param mvts MVTs to activate.
     * @return An implementation-dependant representation of the active MVTs.
     */
    String addMvts(List<String> mvts);
}
