package com.sww.launcher.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import com.sww.launcher.variables.Reference;

public class Window extends Gui {
    
	private static final long serialVersionUID = -5255119516283869295L;
	private static int defaultCloseOperation = EXIT_ON_CLOSE;
	
	private static String name;
	private static String location;
	private static String version;
	
	public void init() {
		setLayouts();
		setText();
		setSize();
		setFont();
		setViewportViewer();
		
		closeButton.addActionListener(ae);
		
		addComponents();
		setBounds();
		panel0();
	}
	
	protected void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);

        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            switch (defaultCloseOperation) {
                case HIDE_ON_CLOSE:
                    setVisible(false);
                    break;
                case DISPOSE_ON_CLOSE:
                    dispose();
                    break;
                case EXIT_ON_CLOSE:
                    // This needs to match the checkExit call in
                    // setDefaultCloseOperation
                    System.exit(0);
                    break;
                case DO_NOTHING_ON_CLOSE:
                default:
            }
        }
    }
	
	public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }
	
	LocalMouseEvent me = new LocalMouseEvent();
	LocalActionEvent ae = new LocalActionEvent();
	
	public static class LocalMouseEvent extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

	}
	
	public static class LocalActionEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(e.getSource().equals(profileNameField) && e.getSource().equals(locationField)) {
				
			}
			if(e.getSource().equals(closeButton)) {
				closeButtonAction(e);
			}
			if(e.getSource().equals(playButton)) {
				playButtonAction(e);
			}
			if(e.getSource().equals(newProfileButton)) {
				newProfileButtonAction(e);
			}
			if(e.getSource().equals(settingsButton)) {
				settingButtonAction(e);
			}
		}
		
		private void settingButtonAction(ActionEvent e) {

			
		}

		private void playButtonAction(ActionEvent e) {			

		}

		private void closeButtonAction(ActionEvent e) {

			System.exit(0);
		}
		
		protected static void newProfileButtonAction(ActionEvent e) {
			if(profileNameField != null) {
				name = profileNameField.getText();
				if(locationField == null) {
					// Default Save Location
					location = Reference.SaveLocation;
				} else {
					location = locationField.getText();
					Reference.SaveLocation = location;
				}
				version = selectionBox.getSelectedItem().toString();
			} else {
				return;
			}
			
			Reference.TableList.add(name);
			Reference.TableList.add(version);
			Reference.TableList.add(location);
			Reference.TableList.add(false);
			List<Object> list = new ArrayList<Object>(Reference.TableList);
			Reference.TableList.clear();
			Reference.TableListofLists.add(list);
		}

		
	}

}