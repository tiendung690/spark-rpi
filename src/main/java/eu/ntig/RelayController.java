package eu.ntig;

/** Handles GET request by turning relays on/off. */
public class RelayController {

    static final String BAD_STATE = "Bad relayState (use \"on\" or \"off\")";
    static final String BAD_VALUE = "Value error (bad relay id)";
    Relay relay_1 = null;
    Relay relay_2 = null;

    protected String formatReply(String relay, boolean state)
    {
        return "{ \"" + relay + "\": " + (state ? "true" : "false") + "}";
    }


    /**
     * Handles query parameters and sets given relay on or off.
     *
     * @param request: Uses query parameter 'relayNr' being '1' or '2'
     *     and 'state' being 'on' or 'off'.
     * @return Diagnostic string, usable in UI.
     * @throws ParamException If parameters are missing or wrong.
     */
    public String setState(spark.Request request) throws ParamException
    {
        String state = request.queryParams("state");
        if (!("on".equals(state) || "off".equals(state))) {
            throw new ParamException(401, BAD_STATE);
        }
        String relayNr = request.queryParams("relayNr");
        if ("1".equals(relayNr)) {
            relay_1.setState("on".equals(state));
            return formatReply("relay1", "on".equals(state));
        } else if ("2".equals(relayNr)) {
            relay_2.setState("on".equals(state));
            return formatReply("relay2", "on".equals(state));
        }
        throw new ParamException(401, BAD_VALUE);
    }

    /**
     * Return state of given relay.
     *
     * @param request: Uses query parameter 'relayNr' being '1' or '2'.
     * @return "on" or "off".
     */
    public String getState(spark.Request request) throws ParamException
    {
        String relayNr = request.queryParams("relayNr");
        if ("1".equals(relayNr)) {
            return formatReply("relay1", relay_1.getState());
        } else if ("2".equals(relayNr)) {
            return formatReply("relay2", relay_2.getState());
        }
        throw new ParamException(401, BAD_VALUE);
    }

    public RelayController()
    {
        relay_1 = new Relay(Config.RELAY_1_PIN);
        relay_2 = new Relay(Config.RELAY_2_PIN);
    }

}


/* vim: set expandtab ts=4 sw=4: */
