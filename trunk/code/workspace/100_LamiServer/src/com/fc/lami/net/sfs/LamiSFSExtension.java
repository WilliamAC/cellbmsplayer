package com.fc.lami.net.sfs;

import com.cell.j2se.CAppBridge;
import com.fc.lami.LamiConfig;
import com.fc.lami.MessageFactory;
import com.fc.lami.Server;
import com.net.ExternalizableFactory;
import com.net.server.ServerListener;
import com.net.sfsimpl.server.ServerExtenstion;

public class LamiSFSExtension extends ServerExtenstion
{
	@Override
	public void init() 
	{
		CAppBridge.initNullStorage();
		LamiConfig.load(LamiConfig.class, super.getConfigProperties());

		super.init();
		
		trace(new Object[] { "Lami SFSExtension started" });
		
//		try {
//			FlashCrossdomainService.main(new String[]{});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	@Override
	protected ServerListener createListener() throws Exception {
		return new Server(this);
	}
	
	@Override
	public ExternalizableFactory createFactory() {	
		return new MessageFactory();
	}
	
	@Override
	public void destroy() 
	{
		super.destroy();
	}
}
