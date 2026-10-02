import javax.swing.*;
import java.awt.*;

// Inheritance: ColorPanel is a JPanel with a layout and a changeColor method
class ColorPanel extends JPanel {

    // Constructor: sets the starting color and the layout of the panel
    public ColorPanel(Color startColor) {
        setBackground(startColor);
        setLayout(new GridBagLayout());
    }

    public void changeColor(Color color) {
        setBackground(color);
    }
}

public class EVENT_DRIVEN_PROGRAMMING_ASS_1_JOSHUA_OSANGIE_KAMARA_905004108 {

    private static final String WELCOME_TEXT =
            "Welcome to Java Swing First Individual Assignment by Joshua Osangie Kamara";
    private static final Color PANEL_COLOR = new Color(235, 242, 252);   // light blue
    private static final Color BUTTON_COLOR = new Color(30, 80, 160);    // dark blue

    private final JPanel panel;
    private final JLabel label;
    private boolean originalText = true;

    // Constructor: builds the window exactly as laid out in the Figma wireframe
    public EVENT_DRIVEN_PROGRAMMING_ASS_1_JOSHUA_OSANGIE_KAMARA_905004108() {
        JFrame frame = new JFrame();
        panel = new ColorPanel(PANEL_COLOR);
        label = new JLabel(WELCOME_TEXT);
        JButton textButton = createButton("Change Text");
        JButton colorButton = createButton("Change Background");

        // Label: centred near the top of the panel
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Layout: label on the first row, two equal buttons side by side below it
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(80, 0, 50, 0);
        panel.add(label, c);

        c.gridwidth = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 15, 0, 15);
        c.gridx = 0;
        panel.add(textButton, c);
        c.gridx = 1;
        panel.add(colorButton, c);

        // Empty filler row pushes everything to the top of the panel
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weighty = 1.0;
        panel.add(Box.createGlue(), c);

        // Events
        textButton.addActionListener(_ -> {
            originalText = !originalText;
            label.setText(originalText ? WELCOME_TEXT : "The text has been changed!");
        });
        colorButton.addActionListener(_ ->
                ((ColorPanel) panel).changeColor(
                        new Color((int) (Math.random() * 0x1000000))));

        frame.add(panel);

        // Frame settings
        frame.setTitle("EVENT_DRIVEN_PROGRAMMING_ASS_1_JOSHUA_OSANGIE_KAMARA_905004108");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Application icon: title bar + taskbar (put icon.png in src, next to your .java file)
        java.net.URL iconUrl = getClass().getResource("/icon.png");
        if (iconUrl != null) {
            Image appIcon = new ImageIcon(iconUrl).getImage();
            frame.setIconImage(appIcon);

            // Taskbar / Dock icon (needed on macOS, harmless elsewhere)
            try {
                if (Taskbar.isTaskbarSupported()
                        && Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) {
                    Taskbar.getTaskbar().setIconImage(appIcon);
                }
            } catch (Exception ignored) {}
        } else {
            System.out.println("icon.png not found on classpath");
        }

        frame.setVisible(true);
    }

    // Creates a dark blue button with white text, same size for both buttons
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(190, 50));
        button.setBackground(BUTTON_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                EVENT_DRIVEN_PROGRAMMING_ASS_1_JOSHUA_OSANGIE_KAMARA_905004108::new);
    }
}