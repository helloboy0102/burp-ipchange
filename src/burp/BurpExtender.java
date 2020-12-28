package burp;


import java.io.PrintWriter;

import java.util.Random;


public class BurpExtender  implements IBurpExtender, IIntruderPayloadGeneratorFactory,IIntruderPayloadGenerator
{	
	private IBurpExtenderCallbacks callbacks;
	private  IExtensionHelpers helpers;





	@Override
	public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks)
	{
		this.callbacks = callbacks;
		helpers = callbacks.getHelpers();
		callbacks.setExtensionName("ipchange by everyone loveburps"); //插件名称
		callbacks.registerIntruderPayloadGeneratorFactory(this);

	}









	//IIntruderPayloadGeneratorFactory 所需实现的2个函数
	@Override
	public String getGeneratorName() {
		return "ipchanges";
	}

	@Override
	public IIntruderPayloadGenerator createNewInstance(IIntruderAttack attack) {

		return this;
	}


	//IIntruderPayloadGenerator 所需实现的三个函数
	@Override
	public boolean hasMorePayloads() {
		return true;
	}

	@Override
	public byte[] getNextPayload(byte[] baseValue) {

		Random r = new Random();
		String ips=r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);

		return ips.getBytes();


	}

	@Override
	public void reset() {

	}

	//////////////////////////////////////////////各种burp必须的方法 --end//////////////////////////////////////////////////////////////
}