//package cn.catguild.butler.deploy;
//
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.Collections;
//
///**
// * @author xiyan
// * @date 2022-02-27 21:10
// */
//public class FastAutoGeneratorTest {
//
//	/**
//	 * 执行 run
//	 */
//	public static void main(String[] args) {
//		FastAutoGenerator.create("jdbc:mysql://180.76.120.236:3306/cat_butler_test?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&tinyInt1isBit=false&allowMultiQueries=true&serverTimezone=GMT%2B8",
//				"root", "kLYSE*XbFAu3RN6l")
//			.globalConfig(builder -> {
//				builder.author("xiyan") // 设置作者
//					//.enableSwagger() // 开启 swagger 模式
//					.fileOverride() // 覆盖已生成文件
//					.outputDir("D:\\Document\\Programme\\Java\\github\\cat-butler\\src\\main\\java"); // 指定输出目录
//			})
//			.packageConfig(builder -> {
//				builder.parent("cn.catguild.butler.generator") // 设置父包名
//					.moduleName("butler") // 设置父包模块名
//					.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\Document\\Programme\\Java\\github\\cat-butler\\src\\main\\resources")); // 设置mapperXml生成路径
//			})
//			.strategyConfig(builder -> {
//				builder.addInclude("user"); // 设置需要生成的表名
//				//.addTablePrefix("t_", "c_"); // 设置过滤表前缀
//			})
//			.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//			.execute();
//	}
//
//}
