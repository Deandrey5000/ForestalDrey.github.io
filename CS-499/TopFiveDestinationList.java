import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    @SuppressWarnings("unused")
	public static void main(String[] args) {
    	
    //  Create instance of authentication
    	Authentication id_Password = new Authentication();
    	
    //  Create instance of login page
    	LoginPage loginPage = new LoginPage(id_Password.getLoginInfo());
    		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    /**
	 * Declare top destination as static final to resolve safety type
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<TextAndIcon> listModel;

    public TopDestinationListFrame() { 
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel<TextAndIcon>();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        addDestinationNameAndPicture("1. Cozimel, Mexico. Fishing boat.", new ImageIcon(getClass().getResource("/resources/boat.jpg")));
        addDestinationNameAndPicture("2. Thai, Thailand. Boat waiting to fishing. ", new ImageIcon(getClass().getResource("/resources/lake.jpg")));
        addDestinationNameAndPicture("3. Potlant, alaska. Spectacular mountain view. ", new ImageIcon(getClass().getResource("/resources/Mountain.jpg")));
        addDestinationNameAndPicture("4. Kolou, Chili. Beack in the wineter. ", new ImageIcon(getClass().getResource("/resources/SeaShore.jpg")));
        addDestinationNameAndPicture("5. Sandlake, Florida. Beautiful day by the water.", new ImageIcon(getClass().getResource("/resources/shore.jpg")));
        
        JList<TextAndIcon> list = new JList<TextAndIcon>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);
        
     // Add text to label.
        JLabel nameLabel = new JLabel("Developer: Anderson Forestal");
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}

// Class that set and return text and icon
class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}

// Sets the position of text and icon
class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer<Object> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    @Override
	public Component getListCellRendererComponent(JList<?> list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    @Override
	public void validate() {}
    @Override
	public void invalidate() {}
    @Override
	public void repaint() {}
    @Override
	public void revalidate() {}
    @Override
	public void repaint(long tm, int x, int y, int width, int height) {}
    @Override
	public void repaint(Rectangle r) {}
}