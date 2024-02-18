package by.sportliner.lk.core.support.html;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class HtmlBuilders {

    public static FromFreemarkerTemplateBuilder fromTemplate() {
        return new FromFreemarkerTemplateBuilder();
    }

    public static class FromFreemarkerTemplateBuilder {

        private Resource templateSource;

        private final Map<String, Object> variables = new LinkedHashMap<>();

        public FromFreemarkerTemplateBuilder template(Resource templateSource) {
            this.templateSource = templateSource;
            return this;
        }

        public FromFreemarkerTemplateBuilder variable(String key, Object value) {
            this.variables.put(key, value);
            return this;
        }

        public FromFreemarkerTemplateBuilder variables(Map<String, Object> variables) {
            this.variables.putAll(variables);
            return this;
        }

        public String toHtml() {
            Configuration configuration = new Configuration(new Version("2.3.31"));

            try (StringWriter out = new StringWriter()) {
                Template template = new Template("template", createReader(templateSource), configuration);

                template.process(variables, out);

                return out.getBuffer().toString();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
        }

        private Reader createReader(Resource resource) throws IOException {
            return new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
        }
    }

}
