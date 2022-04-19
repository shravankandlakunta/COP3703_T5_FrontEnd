import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class loginScreen {

	protected Shell shell;
	private Text txtUsername;
	private Text txtPassword;
	static String password;
	static String username;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			loginScreen window = new loginScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		txtUsername = new Text(shell, SWT.BORDER);
		txtUsername.setText("username");
		txtUsername.setBounds(138, 72, 165, 21);
		
		txtPassword = new Text(shell, SWT.BORDER);
		txtPassword.setText("password");
		txtPassword.setBounds(138, 118, 165, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				username = txtUsername.getText();
				password = txtPassword.getText();
				
				// Open next screen and close current one.
				shell.close();
				menuScreen.openMenu();
			}
		});
		btnLogin.setBounds(180, 163, 75, 25);
		btnLogin.setText("Login");
		
		Label lblUnfCourseManager = new Label(shell, SWT.NONE);
		lblUnfCourseManager.setAlignment(SWT.CENTER);
		lblUnfCourseManager.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		lblUnfCourseManager.setBounds(84, 10, 274, 40);
		lblUnfCourseManager.setText("UNF Course Manager");

	}
}