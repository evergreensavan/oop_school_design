package com.kb.school;

import org.apache.log4j.Logger;

/**
 * Created by kbozoglu on 04.07.2015.
 */
public class ValidationUtils {
    private static Logger logger = Logger.getLogger(ValidationUtils.class);

    //School names and Lesson titles validation
    public static boolean validateName(String name){
        logger.debug("This method will validate the parameter");
        if(name == null){
            logger.error("You can not set \"null\" for this parameter");
            return false;
        }
        if(name.length() <= 3){
            logger.error("This parameter length must be more than 3 characters.");
            return false;
        }
        if(name.length() > 10){
            logger.error("This parameter length must be less than 11 characters.");
            return false;
        }
        logger.info("This is a valid parameter");
        return true;
    }
}
