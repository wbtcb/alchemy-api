# alchemy-api

Kotlin Alchemy API is an interface to the Alchemy API.

## Usage:

To get a Alchemy API into your build add:

## Maven dependencies:

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
    
	<dependency>
	    <groupId>com.github.wbtcb</groupId>
	    <artifactId>alchemy-api</artifactId>
	    <version>version</version>
	</dependency>
	
## Gradle dependencies:

	allprojects {
		repositories {
			maven { url = uri ("https://jitpack.io") }
		}
	}
    
	dependencies {
	        implementation 'com.github.wbtcb:alchemy-api:$version'
	}

## Config:

To access Alchemy's API you will need to  [register](https://auth.alchemy.com/signup) for an API Key.

Example of creating a client:
```
@Configuration
class AlchemyClientConfig(
        @Value("\${alchemy.api.key}")
        private val alchemyApiKey: String
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Bean
    fun alchemyClient(): AlchemyClient {
        logger.info("Creating alchemy api client")
        return AlchemyClient(alchemyApiKey)
    }
}
```