package com.example.demo;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		System.out.println(BigDecimal.TEN.compareTo(BigDecimal.TEN));
		Properties properties = new Properties();
//		properties.setProperty("registry.email", "kwan@moomanow.com");
//		properties.setProperty("registry.password", "kwan");
//		properties.setProperty("registry.username", "kwan");
//		properties.setProperty("DOCKER_CERT_PATH", "/Users/kwan/.docker/machine/machines/default");
//		properties.setProperty("DOCKER_MACHINE_NAME", "default");
//		properties.setProperty("DOCKER_TLS_VERIFY", "1");
		properties.setProperty("DOCKER_HOST", "tcp://localhost:2376");
		DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
		    .withProperties(properties).build();
		DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();
		ListContainersCmd listContainersCmd = dockerClient.listContainersCmd().withStatusFilter("running");
		listContainersCmd.getFilters().put("name", Arrays.asList("miner"));
//		StatsCmd statsCmd = dockerClient.statsCmd("miner");
		System.out.println(listContainersCmd.exec());
//		MinerProcess minerProcess = new MinerProcess();
//		
//		minerProcess.start();
		
		
//		Map<String,Object> root = new HashMap<>();
//		try {
//			root.put("pool", new YaampPool());
//			root.put("user", new ConfigUserBean());
//			root.put("alg", "neo");
//			Map context = Ognl.createDefaultContext(root, mem);
//			System.out.println(Ognl.getValue("pool", context, root));
//
//			System.out.println(Ognl.getValue("pool", context, root));
////			String host = (String) Ognl.getValue(api.getConfigPoolBean().getHostFormat(), context,root,String.class);
////			String port = (String) Ognl.getValue(api.getConfigPoolBean().getPortFormat(), context,root,String.class);
////			String user = (String) Ognl.getValue(api.getConfigPoolBean().getUserFormat(), context,root,String.class);
////			String password = (String) Ognl.getValue(api.getConfigPoolBean().getPasswordFormat(), context,root,String.class);
//			
////			System.out.println(Ognl.getValue("pool", context, root));
////			System.out.println(host);
////			System.out.println(port);
////			System.out.println(user);
////			System.out.println(password);
////			appMiner.run(alg, host, port, user, password);
//		} catch (OgnlException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Set<String> listAlg = new HashSet<>();
//		
//		listAlg.add("test");
//		listAlg.add("test2");
//		listAlg.add("test3");
//		listAlg.add("test4");
//		
//		listAlg.stream().forEach((String alg) -> {
//			System.out.println(alg);
//		});
	}
}
