package eu.ntig;

import static spark.Spark.get;

import spark.Spark;
import spark.servlet.SparkApplication;

public class Application implements SparkApplication {

	@Override
	public void init() {
        RelayController relayController = new RelayController();
        get("/api/setRelay", (request, response) -> {
            try {
                return relayController.setState(request);
            } catch (ParamException e) {
                response.status(e.httpCode);
                return e.getMessage();
            }
        });
        get("/api/getRelay", (request, response) -> {
            try {
                return relayController.getState(request);
            } catch (ParamException e) {
                response.status(e.httpCode);
                return e.getMessage();
            }
        });
	}

    public static void main(String[] args) {
        new Application().init();
    }

}


/* vim: set expandtab ts=4 sw=4: */
