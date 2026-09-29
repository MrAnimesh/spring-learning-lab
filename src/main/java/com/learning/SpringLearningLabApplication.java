package com.learning;

import com.learning.ioccontainer.basics.OrderService;
import com.learning.ioccontainer.basics.PaymentService;
import com.learning.ioccontainer.injection.ConstructorInjectionService;
import com.learning.ioccontainer.injection.FieldInjectionService;
import com.learning.ioccontainer.injection.NotificationService;
import com.learning.ioccontainer.multiplebeans.CheckoutService;
import com.learning.ioccontainer.multiplebeans.PaymentGateway;
import com.learning.ioccontainer.multiplebeans.PaymentProcessor;
import com.learning.ioccontainer.scopes.PrototypeService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class SpringLearningLabApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringLearningLabApplication.class, args);
		ApplicationContext context =
				SpringApplication.run(
						SpringLearningLabApplication.class,
						args
				);


		System.out.println("\n>>> ApplicationContext created");

		System.out.println("\n---Getting bean using context---");
		// Getting bean from IOC container which is basically ApplicationContext on top of BeanFactory
		OrderService orderService =
				context.getBean(OrderService.class);

		orderService.placeOrder(); // Using the bean

		PaymentService payment1 =
				context.getBean(PaymentService.class);

		PaymentService payment2 =
				context.getBean(PaymentService.class);

		System.out.println(payment1);
		System.out.println(payment2);

		System.out.println("\n---Checking Singleton if bean is singleton--- ");
		//true because Spring beans are singleton scope by default. only one bean will be created and shared among all
		System.out.println(payment1 == payment2);

		System.out.println("\n---Fetching all the available beans---");
		// Fetches all the beans in the context
		String[] beanNames = context.getBeanDefinitionNames();

//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}

		// Getting all beans from context as context is just created on top on bean factory
		BeanFactory beanFactory = context;

		PaymentService service =
				beanFactory.getBean(PaymentService.class);

		service.pay();

		System.out.println("\n---Getting a bean using bean factory---");
		OrderService orderService1 = beanFactory.getBean(OrderService.class);
		orderService1.placeOrder();

		System.out.println("\n---Counting Number on beans available in the context---");
		int beanCount = context.getBeanDefinitionCount(); // Finds count of bean
		System.out.println(beanCount);

		NotificationService nfs = beanFactory.getBean(NotificationService.class);
		FieldInjectionService fis = beanFactory.getBean(FieldInjectionService.class);
		ConstructorInjectionService cis = context.getBean(ConstructorInjectionService.class);
		fis.process();
		cis.process();


		System.out.println("\n--- Creating objects manually ---");

		ConstructorInjectionService mf = new ConstructorInjectionService(nfs);
		mf.process();

		// It will fail the dependency inject because Spring was never involved.
//		FieldInjectionService manualField =
//				new FieldInjectionService();

//		manualField.process();

		CheckoutService cs = beanFactory.getBean(CheckoutService.class);

		cs.checkout();

		System.out.println("\n---Checking if a bean is available---");
		// To check if bean is available
		boolean isAvailable = context.containsBean("razorpayPaymentGateway");
		System.out.println(isAvailable);

		System.out.println("\n---Getting bean using service name---");
		//Retrieving one directly
		PaymentGateway gateway =
				(PaymentGateway)
						context.getBean("stripePaymentGateway");

		gateway.pay();

		System.out.println("\n---Listing all payment gateways---");
		PaymentProcessor pp = beanFactory.getBean(PaymentProcessor.class);
		pp.listAllTheGateways();

		System.out.println("\n---Prototype Scope---");
		PrototypeService ps1= context.getBean(PrototypeService.class);
		PrototypeService ps2 = beanFactory.getBean(PrototypeService.class);
		System.out.println(ps1+"\n"+ps2);

		System.out.println(ps1 == ps2);



	}
}
