package ca.qc.lpl.emumips.interpreter;

public class PreParse {

	private StringBuilder newString = new StringBuilder();
	
	public PreParse(String s) {

		boolean dquote = false;
		boolean data = false;
		boolean text = false;
		boolean dot = false;

		StringBuilder sb = new StringBuilder();

		for( int i = 0; i < s.length(); ++i ) {
			char c = s.charAt(i);
			switch(c) {
				case '.':
					dot = true;
					break;
				case 'd':
					sb.append('d');
					break;
				case 'a':
					sb.append('a');
					break;
				case 't':
					sb.append('t');
					break;
				case 'e':
					sb.append('e');
					break;
				case 'x':
					sb.append('x');
					break;
				case '"':
					dquote = !dquote;
					break;
				case ':':
					if( dquote == false && data == true ) {
						c = ';';
					}
					break;
			}
			
			newString.append(c);
			if( dot ) {
				dot = false;
				sb = new StringBuilder();
			}
			if( sb.toString().equals("data") ) {
				sb = new StringBuilder();
				data = true;
			} else if( sb.toString().equals("text")) {
				sb = new StringBuilder();
				text = true;
			}
			
			if( data && text ) {
				++i;
				newString.append(s.substring(i));
				i = s.length();
			}
		}
		
		//this.newString = s;
	}
	
	public String getSource() {
		return this.newString.toString();
	}
}
