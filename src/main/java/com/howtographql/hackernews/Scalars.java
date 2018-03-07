package com.howtographql.hackernews;


import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * new scalar type to represent an instant in time
 * @author sjwilliams
 */
public class Scalars {

    public static GraphQLScalarType dateTime = new GraphQLScalarType("DateTime", "DataTime scalar", new Coercing() {
        @Override
        public Object serialize(Object input) {
            //serialize the ZonedDateTime into string on the way out
            return ((ZonedDateTime)input).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        @Override
        public Object parseValue(Object input) {
            return serialize(input);
        }

        @Override
        public Object parseLiteral(Object input) {
            //parse the string values coming in
            if ( input instanceof StringValue ){
                return ZonedDateTime.parse(((StringValue)input).getValue());

            } else {
                return null;
            }
        }
    });

}
