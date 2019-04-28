# Bootstrap

## Step 1 : initialize with springboot

```bash
curl https://start.spring.io/starter.tgz \
-d dependencies=web,lombok \
-d language=java \
-d type=maven-project \
-d baseDir=kata-bank-account-atdd-spring \
-d groupId=com.newlight77 \ 
-d artifactId=kata-bank-account-atdd-spring \
| tar -xzvf -
```

## Step 2 : add dependencies

```xml
		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.11.1</version>
			<scope>test</scope>
		</dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>2.3.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>2.3.1</version>
            <scope>test</scope>
        </dependency>

```

## Step 3 : add build plugins

```xml
            <plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.3</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>test</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.7.0</version>
				<configuration>
					<encoding>UTF-8</encoding>
					<source>1.8</source>
					<target>1.8</target>
					<compilerArgument>-Werror</compilerArgument>
				</configuration>
			</plugin>
```

## Step 4 : add Cucumber runner and StepRefs

src/java/test/cucumber/RunCucumberTest.java :

```java
package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
            "pretty",
            "html:target/cucumber",
            "json:target/cucumber/Cucumber.json",
            "junit:target/cucumber/Cucumber.xml",
    },
    features = {
            "features"
    },
    glue = {
        cucumber.stepdefsstepdefs"
    },
    tags = {
        "@Account, @Deposit"
    }
)
public class RunCucumberTest {
}
```