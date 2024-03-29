package kr.co.seoulit.account;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

   @Override
   protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

      // Map default decorator. This shall be applied to all paths if no other paths match.

      builder.addDecoratorPath("/*", "/WEB-INF/jsp/decorators/decorator.jsp")
            .addExcludedPath("/loginform");
      builder.addTagRuleBundles(new DivExtractingTagRuleBundle());

   }


}