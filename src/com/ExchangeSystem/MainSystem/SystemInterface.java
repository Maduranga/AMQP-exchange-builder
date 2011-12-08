package com.ExchangeSystem.MainSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.wb.swt.SWTResourceManager;



public class SystemInterface implements SelectionListener{
	private Text newExchangeNameText;
	private Text newQueueNameText;
	private Text bindingRoutingKeyText;
	private Button createNewExchangeRadioButton;
	private Button createQueueRadioButton;
	private Button newExchangeButton;
	private Button newQueueButton;
	private Button bindRadioButton;
	private List bindingTargetExchangeList;
	private List bindingTargetQueueList;
	private List bindingDestinationExchangeList;
	private Button bindButton;
	private Button deleteRadioButton;
	private List deleteExchangeList;
	private List deleteQueueList;
	private Button deleteButton;
	private StyledText StatusText;
	private Button saveButton;
	private Button closeButton; 
	
	static int widgetSelcted = -1;
	Display display;
	private Text manualDelExchNameText;
	private Text manualDelQueueNameText;
	private Text serverIPText;
	private Text fileNameText;
	//private String XMLFileName = "system2.xml";
	private String ServerIP = "localhost";
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SystemInterface window = new SystemInterface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(503, 919);
		shell.setText("Admin window");
		shell.setLayout(null);
		
		createNewExchangeRadioButton = new Button(shell, SWT.RADIO);
		createNewExchangeRadioButton.setBounds(10, 100, 187, 24);
		createNewExchangeRadioButton.setText("Create new exchange");
		createNewExchangeRadioButton.addSelectionListener(this);
		
		Label newExchangeNameLabel = new Label(shell, SWT.NONE);
		newExchangeNameLabel.setBounds(32, 145, 108, 17);
		newExchangeNameLabel.setText("Exchange name");
		
		newExchangeNameText = new Text(shell, SWT.BORDER);
		newExchangeNameText.setEnabled(false);
		newExchangeNameText.setBounds(169, 135, 176, 27);
		
		createQueueRadioButton = new Button(shell, SWT.RADIO);
		createQueueRadioButton.setBounds(10, 224, 176, 24);
		createQueueRadioButton.setText("Create new queue");
		createQueueRadioButton.addSelectionListener(this);
		
		newQueueNameText = new Text(shell, SWT.BORDER);
		newQueueNameText.setEnabled(false);
		newQueueNameText.setBounds(169, 266, 176, 27);
		
		Label newQueueNameLabel = new Label(shell, SWT.NONE);
		newQueueNameLabel.setBounds(32, 266, 108, 17);
		newQueueNameLabel.setText("Queue name");
		
		newExchangeButton = new Button(shell, SWT.NONE);
		newExchangeButton.setEnabled(false);
		newExchangeButton.setBounds(396, 135, 91, 29);
		newExchangeButton.setText("Create");
		newExchangeButton.addSelectionListener(this);
		
		newQueueButton = new Button(shell, SWT.NONE);
		newQueueButton.setEnabled(false);
		newQueueButton.setBounds(396, 266, 91, 29);
		newQueueButton.setText("Create");
		newQueueButton.addSelectionListener(this);
		
		bindRadioButton = new Button(shell, SWT.RADIO);
		bindRadioButton.setBounds(10, 335, 147, 24);
		bindRadioButton.setText("Bind");
		bindRadioButton.addSelectionListener(this);
		
		Label bindingTargetExchangelabel = new Label(shell, SWT.NONE);
		bindingTargetExchangelabel.setBounds(32, 365, 96, 17);
		bindingTargetExchangelabel.setText("Target exch.");
		
		Label bindingTargetQueueLabel = new Label(shell, SWT.NONE);
		bindingTargetQueueLabel.setBounds(152, 365, 96, 17);
		bindingTargetQueueLabel.setText("Target queue");
		
		Label bindingDestinationExchangeLabel = new Label(shell, SWT.NONE);
		bindingDestinationExchangeLabel.setBounds(276, 365, 96, 17);
		bindingDestinationExchangeLabel.setText("Destination exch.");
		
		bindingTargetExchangeList = new List(shell, SWT.V_SCROLL|SWT.H_SCROLL);
		bindingTargetExchangeList.setEnabled(false);
		bindingTargetExchangeList.setBounds(32, 400, 96, 79);
		
		bindingTargetQueueList = new List(shell, SWT.V_SCROLL|SWT.H_SCROLL);
		bindingTargetQueueList.setEnabled(false);
		bindingTargetQueueList.setBounds(157, 400, 91, 79);
		
		bindingDestinationExchangeList = new List(shell, SWT.V_SCROLL|SWT.H_SCROLL);
		bindingDestinationExchangeList.setEnabled(false);
		bindingDestinationExchangeList.setBounds(276, 400, 96, 79);
		
		Label bindingRoutingKeyLabel = new Label(shell, SWT.NONE);
		bindingRoutingKeyLabel.setBounds(32, 509, 108, 17);
		bindingRoutingKeyLabel.setText("Routing key");
		
		bindingRoutingKeyText = new Text(shell, SWT.BORDER);
		bindingRoutingKeyText.setEnabled(false);
		bindingRoutingKeyText.setBounds(169, 509, 176, 27);
		
		bindButton = new Button(shell, SWT.NONE);
		bindButton.setEnabled(false);
		bindButton.setBounds(396, 466, 91, 29);
		bindButton.setText("Bind");
		bindButton.addSelectionListener(this);
		
		deleteRadioButton = new Button(shell, SWT.RADIO);
		deleteRadioButton.setBounds(10, 581, 114, 24);
		deleteRadioButton.setText("Delete");
		deleteRadioButton.addSelectionListener(this);
		
		Label deleteExchangeLabel = new Label(shell, SWT.NONE);
		deleteExchangeLabel.setBounds(32, 611, 70, 17);
		deleteExchangeLabel.setText("Exchange");
		
		Label deleteQueueLabel = new Label(shell, SWT.NONE);
		deleteQueueLabel.setBounds(153, 611, 70, 17);
		deleteQueueLabel.setText("Queue");
		
		deleteExchangeList = new List(shell, SWT.V_SCROLL|SWT.H_SCROLL);
		deleteExchangeList.setEnabled(false);
		deleteExchangeList.setBounds(32, 647, 92, 79);
		
		deleteQueueList = new List(shell,  SWT.V_SCROLL|SWT.H_SCROLL);
		deleteQueueList.setEnabled(false);
		deleteQueueList.setBounds(152, 647, 92, 79);
		
		deleteButton = new Button(shell, SWT.NONE);
		deleteButton.setEnabled(false);
		deleteButton.setBounds(396, 664, 91, 29);
		deleteButton.setText("Delete");
		deleteButton.addSelectionListener(this);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(21, 190, 451, 2);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(21, 315, 451, 14);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(21, 573, 451, 2);
		
		//ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		//scrolledComposite.setExpandVertical(true);
		//scrolledComposite.setBounds(10, 10, 477, 70);
		//scrolledComposite.setExpandHorizontal(true);
		
		StatusText = new StyledText(shell, SWT.V_SCROLL|SWT.H_SCROLL);
		StatusText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_NORMAL_SHADOW));
		StatusText.setSize(246, 79);
		StatusText.setLocation(5, 5);
		//scrolledComposite.setContent(StatusText);
		//scrolledComposite.setMinSize(StatusText.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		saveButton = new Button(shell, SWT.NONE);
		saveButton.setBounds(88, 851, 140, 29);
		saveButton.setText("Save");
		saveButton.addSelectionListener(this);
		
		closeButton = new Button(shell, SWT.NONE);
		closeButton.setBounds(300, 851, 140, 29);
		closeButton.setText("Close");
		closeButton.addSelectionListener(this);
		
		Label manulDelExchName = new Label(shell, SWT.NONE);
		manulDelExchName.setBounds(32, 753, 125, 17);
		manulDelExchName.setText("Exchange name");
		
		manualDelExchNameText = new Text(shell, SWT.BORDER);
		manualDelExchNameText.setEnabled(false);
		manualDelExchNameText.setBounds(169, 753, 176, 27);
		
		Label manulDelQueueName = new Label(shell, SWT.NONE);
		manulDelQueueName.setBounds(32, 794, 108, 17);
		manulDelQueueName.setText("Queue name");
		
		manualDelQueueNameText = new Text(shell, SWT.BORDER);
		manualDelQueueNameText.setEnabled(false);
		manualDelQueueNameText.setBounds(169, 786, 176, 27);
			
		Label lblServerIp = new Label(shell, SWT.NONE);
		lblServerIp.setBounds(257, 10, 70, 17);
		lblServerIp.setText("Server IP");
		
		serverIPText = new Text(shell, SWT.BORDER);
		serverIPText.setText(ServerIP);
		serverIPText.setBounds(333, 5, 139, 27);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(257, 43, 70, 17);
		lblNewLabel.setText("File name");
		
		fileNameText = new Text(shell, SWT.BORDER);
		fileNameText.setText(HighLevelClass.GetFileName());
		fileNameText.setBounds(333, 38, 139, 27);
		
		UpdateAllLists(HighLevelClass.GetExchangeList(), HighLevelClass.GetQueueList());
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void EnableOptions(int selectedOption)
	{
		switch (selectedOption)
		{
		case 1: // new exchange
			EnableNewExchange(true);
			EnableNewQueue(false);
			EnableBinding(false);
			EnableDelete(false);
			break;
			
		case 2:
			EnableNewExchange(false);
			EnableNewQueue(true);
			EnableBinding(false);
			EnableDelete(false);
			break;
			
		case 3:
			EnableNewExchange(false);
			EnableNewQueue(false);
			EnableBinding(true);
			EnableDelete(false);
			break;
			
		case 4:
			EnableNewExchange(false);
			EnableNewQueue(false);
			EnableBinding(false);
			EnableDelete(true);
			break;
			
		}
	}

	public void EnableNewExchange(boolean enable)
	{
		if(enable)
		{
			newExchangeButton.setEnabled(true);
			newExchangeNameText.setEnabled(true);
		}
		else
		{
			newExchangeButton.setEnabled(false);
			newExchangeNameText.setEnabled(false);
		}
	}
	
	public void EnableNewQueue(boolean enable)
	{
		if(enable)
		{
			newQueueButton.setEnabled(true);
			newQueueNameText.setEnabled(true);
		}
		else
		{
			newQueueButton.setEnabled(false);
			newQueueNameText.setEnabled(false);
		}
	}
	
	public void EnableBinding(boolean enable)
	{
		if(enable)
		{
			bindButton.setEnabled(true);
			bindingTargetExchangeList.setEnabled(true);
			bindingTargetQueueList.setEnabled(true);
			bindingDestinationExchangeList.setEnabled(true);
			bindingRoutingKeyText.setEnabled(false);
		}
		else
		{
			bindButton.setEnabled(false);
			bindingTargetExchangeList.setEnabled(false);
			bindingTargetQueueList.setEnabled(false);
			bindingDestinationExchangeList.setEnabled(false);
			bindingRoutingKeyText.setEnabled(false);
		}
	}
	
	public void EnableDelete(boolean enable)
	{
		if(enable)
		{
			deleteExchangeList.setEnabled(true);
			deleteQueueList.setEnabled(true);
			deleteButton.setEnabled(true);
			manualDelExchNameText.setEnabled(true);
			manualDelQueueNameText.setEnabled(true);
		}
		else
		{
			deleteExchangeList.setEnabled(false);
			deleteQueueList.setEnabled(false);
			deleteButton.setEnabled(false);
			manualDelExchNameText.setEnabled(false);
			manualDelQueueNameText.setEnabled(false);
		}
	}
	
	

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void widgetSelected(SelectionEvent event) {
	
		if(createNewExchangeRadioButton.isFocusControl())
		{
			if(widgetSelcted != 1)
			{
				widgetSelcted = 1;
				EnableOptions(1);
			}
		}

		else if(createQueueRadioButton.isFocusControl())
		{
			if(widgetSelcted != 2)
			{
				widgetSelcted = 2;
				StatusText.append("Declaring new queue...\n");
				StatusText.setTopIndex(StatusText.getLineCount() - 1);
				EnableOptions(2);
			}
		}
		
		else if(bindRadioButton.isFocusControl())
		{
			if(widgetSelcted != 3)
			{
				widgetSelcted = 3;
				EnableOptions(3);			
			}
		}
		else if(deleteRadioButton.isFocusControl())
		{
			if(widgetSelcted != 4)
			{
				widgetSelcted = 4;
				StatusText.append("Deleting...\n");
				StatusText.setTopIndex(StatusText.getLineCount() - 1);
				EnableOptions(4);
			}
		}
		
		else if(newExchangeButton.isFocusControl())
		{
			String exchName = newExchangeNameText.getText();
			
			if (exchName.equals(""))
			{
				StatusText.append("Enter a queue name \n");
			}
			else
			{
				StatusText.append("Adding new exchange: " + exchName + "\n");
				HighLevelClass.XMLRootClass.AddExchange(exchName);
			}
			
			newExchangeNameText.setText("");
		}
		
		else if(newQueueButton.isFocusControl())
		{
			String queueName = newQueueNameText.getText();
			
			if (queueName.equals(""))
			{
				StatusText.append("Enter a queue name \n");
			}
			else
			{
				StatusText.append("Adding new queue: " + queueName + "\n");
				HighLevelClass.XMLRootClass.AddQueue(queueName);
			}
			
			newQueueNameText.setText("");
		}

		else if(bindButton.isFocusControl())
		{
			int targetExchIdx = bindingTargetExchangeList.getSelectionIndex();
			int targetqueueIdx = bindingTargetQueueList.getSelectionIndex();
			int destExchIdx = bindingDestinationExchangeList.getSelectionIndex();
			String routingKey = bindingRoutingKeyText.getText();
			//StatusText.append("--> " + targetExchIdx + "--> " + targetqueueIdx + "--> " + destExchIdx);
					
			if(targetExchIdx>-1 && targetqueueIdx>-1 && destExchIdx>-1)
				StatusText.append("Make only two selections \n");
			else if(targetExchIdx>-1 && targetqueueIdx>-1)
				StatusText.append("Choose a target and a destination \n");
			else if((targetExchIdx>-1 || targetqueueIdx>-1) && destExchIdx<0)
				StatusText.append("Choose a destination \n");
			else if(targetExchIdx<0 && targetqueueIdx<0)
				StatusText.append("Choose a target \n");
			//else if (routingKey.equals(""))
				//StatusText.append("Enter a routing key \n");
			else if (targetExchIdx == destExchIdx)
				StatusText.append("Choose different exchanges to bind \n");
			
			else if (targetExchIdx>-1)  // an exchange is selected
			{
				String targetExchName = bindingTargetExchangeList.getItem(targetExchIdx);
				String destExchName   = bindingDestinationExchangeList.getItem(destExchIdx);
				//StatusText.append("Binding: " + targetExchName + " -----> " + destExchName + "\n");
				//HighLevelClass.XMLRootClass.BindExchangeToExchange(targetExchName, destExchName, routingKey);
				HighLevelClass.XMLRootClass.BindExchangeToExchange(targetExchName, destExchName, targetExchName);
			}
			else if (targetqueueIdx>-1)  // a queue is selected
			{
				String targetQueueName = bindingTargetQueueList.getItem(targetqueueIdx);
				String destExchName    = bindingDestinationExchangeList.getItem(destExchIdx);
				//StatusText.append(targetQueueName + " -----> " + destExchName + "\n");
				//HighLevelClass.XMLRootClass.BindQueueToExchange(targetQueueName, destExchName, routingKey);
				HighLevelClass.XMLRootClass.BindQueueToExchange(targetQueueName, destExchName, targetQueueName);
			}
			
			bindingTargetExchangeList.deselectAll();
			bindingTargetQueueList.deselectAll();
			bindingDestinationExchangeList.deselectAll();
		}
		
		else if (deleteButton.isFocusControl())
		{
			int deleteExchIdx = deleteExchangeList.getSelectionIndex();
			int deleteQueueIdx = deleteQueueList.getSelectionIndex();
			
			if(!manualDelExchNameText.getText().equals(""))
			{
				String deleteExchName = manualDelExchNameText.getText();
				StatusText.append("Manual exchange delete: " + deleteExchName + "\n");
				HighLevelClass.XMLRootClass.RemoveExchange(deleteExchName);
			}
			else if(!manualDelQueueNameText.getText().equals(""))
			{
				String deleteQueueName = manualDelQueueNameText.getText();
				StatusText.append("Manual queue delete: " + deleteQueueName + "\n");
				HighLevelClass.XMLRootClass.RemoveQueue(deleteQueueName);
			}
			
			else if(deleteExchIdx<0 && deleteQueueIdx<0)
				StatusText.append("Choose a target to delete \n");
			else if(deleteExchIdx>-1)
			{
				String deleteExchName = deleteExchangeList.getItem(deleteExchIdx);
				HighLevelClass.XMLRootClass.RemoveExchange(deleteExchName);
			}
			else if(deleteQueueIdx>-1)
			{
				String deleteQueueName = deleteQueueList.getItem(deleteQueueIdx);
				HighLevelClass.XMLRootClass.RemoveQueue(deleteQueueName);
			}
			
			
			deleteExchangeList.deselectAll();
			deleteQueueList.deselectAll();
			manualDelExchNameText.setText("");
			manualDelQueueNameText.setText("");
			//UpdateAllLists(HighLevelClass.GetExchangeList(), HighLevelClass.GetQueueList());
		}
		
		
		else if(saveButton.isFocusControl())
		{
			StatusText.append("Saving to " + fileNameText.getText()+ "\n");
			HighLevelClass.SetFileName(fileNameText.getText());
			HighLevelClass.SaveChanges();
		}
		
		else if(closeButton.isFocusControl())
		{
			StatusText.append("Closing...\n");
			HighLevelClass.CloseApplication();
		}
		
		
	}
	
	
	public void UpdateAllLists(java.util.List <Exchange> ExchangeList, java.util.List <Queue> QueueList)
	{

		bindingTargetExchangeList.removeAll();
		bindingDestinationExchangeList.removeAll();
		deleteExchangeList.removeAll();
		bindingTargetQueueList.removeAll();
		deleteQueueList.removeAll();
		
		for(int idx=0; idx<ExchangeList.size(); ++idx)
		{
			String exchName = ExchangeList.get(idx).toString();
			
			bindingTargetExchangeList.add(exchName);
			bindingDestinationExchangeList.add(exchName);
			deleteExchangeList.add(exchName);
		}
		
		for(int idx=0; idx<QueueList.size(); ++idx)  //QueueList.size()
		{
			String queueName = QueueList.get(idx).toString();
			bindingTargetQueueList.add(queueName);
			deleteQueueList.add(queueName);
		}	
	}
	
	
	public void CloseWindow()
	{
		display.close();
	}
	
	public void ShowInStatusText(String text)
	{
		StatusText.append(text + "\n");
	}
	
	public String GetServerIP()
	{
		return serverIPText.getText();
	}
	
	public String GetFileName()
	{
		return fileNameText.getText();
	}
}
