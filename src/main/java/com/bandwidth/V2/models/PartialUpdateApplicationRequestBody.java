package com.bandwidth.V2.models;

//Package for converting class to JSON
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

//Java packages
import java.util.ArrayList;

/**
 * Wrapper class for holding request parameters for ApplicationController.partialUpdateApplication()
 */
public class PartialUpdateApplicationRequestBody {

    /**
     * Constructor for PartialUpdateApplicationRequestBody
     */
    public PartialUpdateApplicationRequestBody() {
   
    }

    /**
     * Returns a JSON representation of the class
     *
     * @return String: JSON representation of the class
     *
     * @throws JsonProcessingException JsonProcessingException
     */
    public String toJSON() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(this);
    }
}
