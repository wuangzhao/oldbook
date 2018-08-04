import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlMap {
    public void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warinngs = new ArrayList<>();
        boolean overwirte = true;
        File configFile = new File("/Users/angzhao/Desktop/oldbook/src/main/resources/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warinngs);
        Configuration configuration = configurationParser.parseConfiguration(configFile);
        ShellCallback callback = new DefaultShellCallback(overwirte);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warinngs);
        myBatisGenerator.generate(null);

    }

    public static void main(String[] args) throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        GeneratorSqlMap generatorSqlMap = new GeneratorSqlMap();
        generatorSqlMap.generator();
    }
}
