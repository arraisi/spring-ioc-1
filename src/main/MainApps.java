package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tdi.HelloWorld;
import tdi.HelloWorldConfig;
import tdi.config.KonfigurasiApps;
import tdi.service.VolService;

public class MainApps {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		 //ctx.register(HelloWorldConfig.class);
		 ctx.register(KonfigurasiApps.class);
		 ctx.refresh();
		 
		/* HelloWorld hw =  ctx.getBean(HelloWorld.class);
		 hw.setMessage("dddddddddddddddd ");
		 hw.getMessage();*/
		 
		 VolService vol = ctx.getBean(VolService.class);
		 System.out.println(vol.hitungLuasTinggi(10, 12, 20));
	}

}
