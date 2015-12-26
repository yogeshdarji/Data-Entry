
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Limit extends PlainDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int limit;

	Limit(int limitation) {
		super();
		this.limit = limitation;
	}

	public void insertString(int offset, String str, AttributeSet set)
			throws BadLocationException {
		if (str == null)
			return;

		else if ((getLength() + str.length()) <= limit) {
			str = str.toUpperCase();
			super.insertString(offset, str, set);

		}
	}
}
