package CucumberPack;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //путь к папке с .feature файлами. Фреймворк будет искать файлы в этой и во всех дочерних папках. {«src/test/features», «src/test/feat»};
        features = "src/test/features",
        //пакет, в котором находятся классы с реализацией шагов и «хуков». glue = {«ru.savkk.test», «ru.savkk.hooks»};
        glue = "ru.savkk.test",
        //фильтр запускаемых тестов по тэгам. Список тэгов можно перечислить через запятую. Символ ~ исключает тест из списка запускаемых тестов, например ~@fail;
        tags = "@all",
        //если true, то сразу после запуска теста фреймворк проверяет, все ли шаги теста разработаны, если нет, то выдает предупреждение. При false предупреждение будет выдаваться по достижении неразработанного шага. По умолчанию false.
        dryRun = false,
        //если true, то при встрече неразработанного шага тест остановится с ошибкой. False — неразработанные шаги пропускаются. По умолчанию false.
        strict = false,
        // указывает в каком формате фреймворк будет предлагать шаблон для нереализованных шагов. Доступны значения: SnippetType.CAMELCASE, SnippetType.UNDERSCORE.
        snippets = SnippetType.UNDERSCORE
        //name – фильтрует запускаемые тесты по названиям удовлетворяющим регулярному выражению. Для фильтрации запускаемых тестов нельзя одновременно использовать опции tags и name.
//        name = "^Успешное|Успешная.*"
)
public class CucumberBaseEduTest {
}