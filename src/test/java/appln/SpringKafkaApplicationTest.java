package appln;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import service.MySender;
import service.Receiver;

@SpringBootTest
@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackageClasses = {MySender.class, Receiver.class})
@DirtiesContext
@EmbeddedKafka(partitions = 1,
        topics = {SpringKafkaApplicationTest.HELLOWORLD_TOPIC})
public class SpringKafkaApplicationTest {

    static final String HELLOWORLD_TOPIC = "helloworld.t";

//    @Autowired
    private Receiver receiver = new Receiver();

    @Autowired
    private MySender sender;

    @Test
    public void testReceive() throws Exception {
        sender.send("Hello Spring Kafka!");

//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}
