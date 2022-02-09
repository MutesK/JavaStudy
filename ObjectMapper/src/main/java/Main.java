import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Main
{
    public static void main(String[] args)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11-1234");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("K5");
        car2.setCarNumber("11-1234");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        System.out.println(user);

        String json = null;
        try
        {
            json = objectMapper.writeValueAsString(user);
            System.out.println(json);
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }

        try
        {
            JsonNode jsonNode = objectMapper.readTree(json);

            String name = jsonNode.get("name").asText();
            int age = jsonNode.get("age").asInt();

            JsonNode cars = jsonNode.get("cars");
            ArrayNode arrayNode = (ArrayNode)cars;

            List<Car> _cars = objectMapper.convertValue(arrayNode,
                    new TypeReference<List<Car>>(){});

            System.out.println(name);
            System.out.println(age);
            System.out.println(_cars);

            ObjectNode objectNode = (ObjectNode) jsonNode;
            objectNode.put("name", "Mute");
            objectNode.put("age", 10);

            System.out.println(objectNode.toPrettyString());
        }
        catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }


    }
}
