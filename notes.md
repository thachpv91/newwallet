##I. Maven
 	#1. ERROR: GenerateDot fails with Maven 3.2.5 and 3.3.3: NoClassDefFoundError: org/eclipse/aether/spi/connector/Transfer$State
	    - Solution: Maven-3.1.1
	            `http://mirrors.viethosting.vn/apache/maven/maven-3/3.1.1/binaries/`
    #2. Repository
    	- Search: http://mvnrepository.com
    	- Local jar: 
    			`mvn install:install-file 
    				-Dfile=/home/bapvn/Downloads/BitCoinWallets/AndroidWallets/digitalcoinj-core-0.12.3.jar 
    				-DgroupId=org.bitcoinj 
    				-DartifactId=digitalcoinj-core 
    				-Dversion=0.12.3 
    				-Dpackaging=jar`
    #3. Skip test
    	`mvn clean install -Dmaven.test.skip=true`

##II. Build
    #1. Install Java
        # search:   apt-cache search oracle-java 
        `sudo apt-get install python-software-properties`
        `sudo add-apt-repository ppa:webupd8team/java`
        `sudo apt-get update`

       ` sudo apt-get install oracle-java8-installer`  

    #2. Install android sdk

        # download android sdk
        `wget http://dl.google.com/android/android-sdk_r24.2-linux.tgz`
        `tar -xvf android-sdk_r24.2-linux.tgz`

        # install all sdk packages
        `cd android-sdk-linux/tools`
        `./android update sdk --no-ui`

        #ANDROID_HOME && PATH 
        # Add the following to your ~/.bashrc file.

        `export ANDROID_HOME=$HOME/Android/android-sdk-linux`
        `export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools`

        # Execute commands from ".bashrc" file 
        `source ~/.bashrc`

    #3. Make && Install bapcoinj-lib
        # make lib
        `./_make_libs.sh`

        # install lib
        `./_setup.sh`


    #4. Make apk
        mvn clean install -Dmaven.test.skip=true

##III. Debug
    #1. Install DDMS
        `sudo apt-get update`
        `sudo apt-get install androidsdk-ddms`