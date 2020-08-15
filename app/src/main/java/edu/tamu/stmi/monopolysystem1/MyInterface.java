package edu.tamu.stmi.monopolysystem1;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

/**
 * Created by chandu on 4/24/18.
 */

public interface MyInterface {

    @LambdaFunction
    ResponseClass monopolyCSCE656(RequestClass request);

}
