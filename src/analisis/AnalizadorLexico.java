/* The following code was generated by JFlex 1.4.3 on 2/09/20 03:30 AM */


package analisis;
import java_cup.runtime.*;
import java.util.ArrayList;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/09/20 03:30 AM from the specification file
 * <tt>Lexico.jflex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  5,  5,  6,  0,  0,  5,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    41,  0, 38,  0,  0, 25, 40,  0, 34, 35, 27, 28, 42, 36, 24, 45, 
     4,  4,  4,  4,  4,  4,  4,  4,  4,  4, 22, 23,  0, 39,  0, 26, 
     0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 32, 37, 33,  0,  0, 
     0, 16, 10, 46, 47, 12,  1,  1,  1, 15,  1,  1, 19,  9,  7,  8, 
     1,  1, 11, 14, 18, 17, 13,  1, 21,  1, 20, 43, 31, 44,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  3,  0,  0,  0,  0,  0,  0,  0,  3,  0,  0,  0,  3,  0,  0, 
     0,  3, 30,  3,  0,  0,  0,  0,  0,  0,  3,  0,  0,  0,  0,  0, 
     0,  0,  0,  2,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 29,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\2\1\4\1\1\1\5\7\3"+
    "\1\6\1\7\1\10\1\2\1\11\1\12\1\13\1\2"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\2\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\2\1\3\1\30"+
    "\1\0\10\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\2\30\1\0\11\30\1\0\1\42"+
    "\10\30\1\0\3\30\1\43\3\30\1\44\1\0\1\45"+
    "\4\30\1\46\1\0\1\30\1\47\2\30\1\0\1\30"+
    "\1\50\1\30\1\0\1\51\1\30\1\0\1\30\1\52"+
    "\1\53";

  private static int [] zzUnpackAction() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\60\0\u0120"+
    "\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\60"+
    "\0\60\0\u02a0\0\60\0\u02d0\0\60\0\u0300\0\60\0\60"+
    "\0\60\0\60\0\60\0\60\0\u0330\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\u0360\0\u0390\0\140\0\u03c0\0\u03f0"+
    "\0\u0420\0\u0450\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\60\0\60\0\60"+
    "\0\u0570\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690\0\u06c0"+
    "\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0\0\140\0\u07e0\0\u0810"+
    "\0\u0840\0\u0870\0\u08a0\0\u08d0\0\u0900\0\u0930\0\u0960\0\u0990"+
    "\0\u09c0\0\u09f0\0\140\0\u0a20\0\u0a50\0\u0a80\0\140\0\u0ab0"+
    "\0\140\0\u0ae0\0\u0b10\0\u0b40\0\u0b70\0\140\0\u0ba0\0\u0bd0"+
    "\0\140\0\u0c00\0\u0c30\0\u0c60\0\u0c90\0\140\0\u0cc0\0\u0cf0"+
    "\0\140\0\u0d20\0\u0d50\0\u0d80\0\60\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\3\3\1\11\1\12\1\13\2\3\1\14\1\3\1\15"+
    "\1\16\2\3\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\2\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\6\1\41\1\42"+
    "\1\43\1\44\1\45\1\3\61\0\1\46\1\47\1\0"+
    "\1\46\2\0\17\46\30\0\2\46\3\0\1\3\55\0"+
    "\1\46\1\47\1\0\1\5\2\0\17\46\30\0\2\46"+
    "\5\0\1\6\43\0\1\6\7\0\1\46\1\47\1\0"+
    "\1\46\2\0\1\46\1\50\15\46\30\0\2\46\1\0"+
    "\1\46\1\47\1\0\1\46\2\0\5\46\1\51\11\46"+
    "\30\0\2\46\1\0\1\46\1\47\1\0\1\46\2\0"+
    "\1\52\15\46\1\53\30\0\2\46\1\0\1\46\1\47"+
    "\1\0\1\46\2\0\5\46\1\54\11\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\12\46\1\55"+
    "\4\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\5\46\1\56\11\46\30\0\2\46\1\0\1\46"+
    "\1\47\1\0\1\46\2\0\11\46\1\57\5\46\30\0"+
    "\2\46\26\0\1\60\62\0\1\61\103\0\1\62\40\0"+
    "\1\63\30\0\1\64\2\0\1\65\7\0\1\66\70\0"+
    "\1\67\21\0\1\70\3\0\1\46\1\47\1\0\1\46"+
    "\2\0\11\46\1\71\5\46\30\0\2\46\3\0\1\46"+
    "\55\0\1\46\1\47\1\0\1\46\2\0\2\46\1\72"+
    "\14\46\23\0\1\73\4\0\2\46\1\0\1\46\1\47"+
    "\1\0\1\46\2\0\11\46\1\74\5\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\13\46\1\75"+
    "\3\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\13\46\1\76\3\46\30\0\2\46\1\0\1\46"+
    "\1\47\1\0\1\46\2\0\4\46\1\77\12\46\30\0"+
    "\2\46\1\0\1\46\1\47\1\0\1\46\2\0\13\46"+
    "\1\100\3\46\30\0\2\46\1\0\1\46\1\47\1\0"+
    "\1\46\2\0\4\46\1\101\12\46\30\0\2\46\1\0"+
    "\1\46\1\47\1\0\1\46\2\0\1\102\16\46\30\0"+
    "\2\46\1\0\1\46\1\47\1\0\1\46\2\0\17\46"+
    "\30\0\1\46\1\103\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\3\46\1\104\13\46\30\0\2\46\22\0\1\105"+
    "\36\0\1\46\1\47\1\0\1\46\2\0\14\46\1\106"+
    "\2\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\5\46\1\107\11\46\30\0\2\46\1\0\1\46"+
    "\1\47\1\0\1\46\2\0\5\46\1\110\11\46\30\0"+
    "\2\46\1\0\1\46\1\47\1\0\1\46\2\0\7\46"+
    "\1\111\7\46\30\0\2\46\1\0\1\46\1\47\1\0"+
    "\1\46\2\0\1\46\1\112\15\46\30\0\2\46\1\0"+
    "\1\46\1\47\1\0\1\46\2\0\2\46\1\113\14\46"+
    "\30\0\2\46\1\0\1\46\1\47\1\0\1\46\2\0"+
    "\15\46\1\114\1\46\30\0\2\46\1\0\1\46\1\47"+
    "\1\0\1\46\2\0\5\46\1\115\11\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\4\46\1\116"+
    "\12\46\30\0\2\46\14\0\1\117\44\0\1\46\1\47"+
    "\1\0\1\46\2\0\4\46\1\120\12\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\1\121\16\46"+
    "\30\0\2\46\1\0\1\46\1\47\1\0\1\46\2\0"+
    "\10\46\1\122\6\46\30\0\2\46\1\0\1\46\1\47"+
    "\1\0\1\46\2\0\4\46\1\123\12\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\10\46\1\124"+
    "\6\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\11\46\1\125\5\46\30\0\2\46\1\0\1\46"+
    "\1\47\1\0\1\46\2\0\1\126\16\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\5\46\1\127"+
    "\11\46\30\0\2\46\13\0\1\130\45\0\1\46\1\47"+
    "\1\0\1\46\2\0\1\46\1\131\15\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\7\46\1\132"+
    "\7\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\1\46\1\133\15\46\30\0\2\46\1\0\1\46"+
    "\1\47\1\0\1\46\2\0\1\134\16\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\2\46\1\135"+
    "\14\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\11\46\1\136\5\46\30\0\2\46\11\0\1\137"+
    "\47\0\1\46\1\47\1\0\1\46\2\0\10\46\1\140"+
    "\6\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\1\141\16\46\30\0\2\46\1\0\1\46\1\47"+
    "\1\0\1\46\2\0\11\46\1\142\5\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\10\46\1\143"+
    "\6\46\30\0\2\46\17\0\1\144\41\0\1\46\1\47"+
    "\1\0\1\46\2\0\1\46\1\145\15\46\30\0\2\46"+
    "\1\0\1\46\1\47\1\0\1\46\2\0\14\46\1\146"+
    "\2\46\30\0\2\46\1\0\1\46\1\47\1\0\1\46"+
    "\2\0\5\46\1\147\11\46\30\0\2\46\7\0\1\150"+
    "\51\0\1\46\1\47\1\0\1\46\2\0\1\151\16\46"+
    "\30\0\2\46\1\0\1\46\1\47\1\0\1\46\2\0"+
    "\1\152\16\46\30\0\2\46\20\0\1\153\40\0\1\46"+
    "\1\47\1\0\1\46\2\0\13\46\1\154\3\46\30\0"+
    "\2\46\23\0\1\155\35\0\1\46\1\47\1\0\1\46"+
    "\2\0\1\46\1\156\15\46\30\0\2\46";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3504];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\4\1\1\11\10\1\2\11\1\1\1\11"+
    "\1\1\1\11\1\1\6\11\1\1\6\11\3\1\1\0"+
    "\10\1\11\11\2\1\1\0\11\1\1\0\11\1\1\0"+
    "\10\1\1\0\6\1\1\0\4\1\1\0\3\1\1\0"+
    "\2\1\1\0\1\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[110];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    //coidgo de usuario en sintaxis java
    //public ArrayList<ErrorG> listaErrores = new  ArrayList<>();



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnalizadorLexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 17: 
          { System.out.println("GUION: "+yytext()); return new Symbol(Simbolos.GUION , yycolumn, yyline, yytext());
          }
        case 44: break;
        case 14: 
          { System.out.println("CORCHETE_C: "+yytext()); return new Symbol(Simbolos.CORCHETE_C , yycolumn, yyline, yytext());
          }
        case 45: break;
        case 11: 
          { System.out.println("MAS: "+yytext()); return new Symbol(Simbolos.MAS , yycolumn, yyline, yytext());
          }
        case 46: break;
        case 25: 
          { System.out.println("DOBLE_PUNTO: "+yytext()); return new Symbol(Simbolos.DOBLE_PUNTO , yycolumn, yyline, yytext());
          }
        case 47: break;
        case 6: 
          { System.out.println("DOS PUNTOS: "+yytext()); return new Symbol(Simbolos.DOS_PUNTOS , yycolumn, yyline, yytext());
          }
        case 48: break;
        case 29: 
          { System.out.println("SALTO_RESERV: "+yytext()); return new Symbol(Simbolos.SALTO_RESERV , yycolumn, yyline, yytext());
          }
        case 49: break;
        case 30: 
          { System.out.println("ESPACIO_BLANCO: "+yytext()); return new Symbol(Simbolos.ESPACIO_BLANCO , yycolumn, yyline, yytext());
          }
        case 50: break;
        case 20: 
          { System.out.println("IGNORAR: "+yytext()); return new Symbol(Simbolos.IGNORAR , yycolumn, yyline, yytext());
          }
        case 51: break;
        case 42: 
          { System.out.println("NO_TERMINAL: "+yytext()); return new Symbol(Simbolos.NO_TERMINAL , yycolumn, yyline, yytext());
          }
        case 52: break;
        case 9: 
          { System.out.println("INTERROGACION: "+yytext()); return new Symbol(Simbolos.INTERROGACION , yycolumn, yyline, yytext());
          }
        case 53: break;
        case 19: 
          { System.out.println("IGUAL: "+yytext()); return new Symbol(Simbolos.IGUAL , yycolumn, yyline, yytext());
          }
        case 54: break;
        case 2: 
          { System.out.println("CUALQUIER_SIM: "+yytext()); 
                                    //ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    //listaErrores.add(e);
                                    return new Symbol(Simbolos.CUALQUIER_SIM , yycolumn, yyline, yytext());
          }
        case 55: break;
        case 34: 
          { System.out.println("REAL: "+yytext()); return new Symbol(Simbolos.REAL , yycolumn, yyline, yytext());
          }
        case 56: break;
        case 37: 
          { System.out.println("ENTERO: "+yytext()); return new Symbol(Simbolos.ENTERO , yycolumn, yyline, yytext());
          }
        case 57: break;
        case 5: 
          { System.out.println("salto: "+yytext()); return new Symbol(Simbolos.SALTO_LINEA , yycolumn, yyline, yytext());
          }
        case 58: break;
        case 38: 
          { System.out.println("CADENA: "+yytext()); return new Symbol(Simbolos.CADENA , yycolumn, yyline, yytext());
          }
        case 59: break;
        case 18: 
          { System.out.println("COMILLAS: "+yytext()); return new Symbol(Simbolos.COMILLAS , yycolumn, yyline, yytext());
          }
        case 60: break;
        case 28: 
          { System.out.println("BETA: "+yytext()); return new Symbol(Simbolos.BETA , yycolumn, yyline, yytext());
          }
        case 61: break;
        case 4: 
          { System.out.println("NUM_VERSION: "+yytext()); return new Symbol(Simbolos.NUMERO, yycolumn, yyline, yytext());
          }
        case 62: break;
        case 3: 
          { System.out.println("letra: "+yytext()); return new Symbol(Simbolos.LETRA , yycolumn, yyline, yytext());
          }
        case 63: break;
        case 24: 
          { System.out.println("id: "+yytext()); return new Symbol(Simbolos.IDENTIFICADOR , yycolumn, yyline, yytext());
          }
        case 64: break;
        case 40: 
          { System.out.println("TERMINAL: "+yytext()); return new Symbol(Simbolos.TERMINAL , yycolumn, yyline, yytext());
          }
        case 65: break;
        case 36: 
          { System.out.println("NOMBRE: "+yytext()); return new Symbol(Simbolos.NOMBRE , yycolumn, yyline, yytext());
          }
        case 66: break;
        case 31: 
          { System.out.println("TAB_RESERV: "+yytext()); return new Symbol(Simbolos.TAB_RESERV , yycolumn, yyline, yytext());
          }
        case 67: break;
        case 12: 
          { System.out.println("LINEA: "+yytext()); return new Symbol(Simbolos.LINEA , yycolumn, yyline, yytext());
          }
        case 68: break;
        case 43: 
          { System.out.println("LAZAMIENTO: "+yytext()); return new Symbol(Simbolos.LANZAMIENTO , yycolumn, yyline, yytext());
          }
        case 69: break;
        case 33: 
          { System.out.println("COMENTARIO_SIMPLE: "+yytext()); return new Symbol(Simbolos.COMENTARIO_SIMPLE , yycolumn, yyline, yytext());
          }
        case 70: break;
        case 15: 
          { System.out.println("PARENTESIS_A: "+yytext()); return new Symbol(Simbolos.PARENTESIS_A , yycolumn, yyline, yytext());
          }
        case 71: break;
        case 23: 
          { System.out.println("LLAVES_C: "+yytext()); return new Symbol(Simbolos.LLAVES_C , yycolumn, yyline, yytext());
          }
        case 72: break;
        case 35: 
          { System.out.println("AUTOR: "+yytext()); return new Symbol(Simbolos.AUTOR , yycolumn, yyline, yytext());
          }
        case 73: break;
        case 10: 
          { System.out.println("ASTERISCO: "+yytext()); return new Symbol(Simbolos.ASTERISCO , yycolumn, yyline, yytext());
          }
        case 74: break;
        case 26: 
          { System.out.println("SEPARACION: "+yytext()); return new Symbol(Simbolos.SEPARACION , yycolumn, yyline, yytext());
          }
        case 75: break;
        case 32: 
          { System.out.println("COMENTARIO_A: "+yytext()); return new Symbol(Simbolos.COMENTARIO_A , yycolumn, yyline, yytext());
          }
        case 76: break;
        case 21: 
          { System.out.println("COMA: "+yytext()); return new Symbol(Simbolos.COMA , yycolumn, yyline, yytext());
          }
        case 77: break;
        case 13: 
          { System.out.println("CORCHETE_A: "+yytext()); return new Symbol(Simbolos.CORCHETE_A , yycolumn, yyline, yytext());
          }
        case 78: break;
        case 16: 
          { System.out.println("PARENTESIS_C: "+yytext()); return new Symbol(Simbolos.PARENTESIS_C , yycolumn, yyline, yytext());
          }
        case 79: break;
        case 39: 
          { System.out.println("VERSION: "+yytext()); return new Symbol(Simbolos.VERSION , yycolumn, yyline, yytext());
          }
        case 80: break;
        case 8: 
          { System.out.println("PUNTO: "+yytext()); return new Symbol(Simbolos.PUNTO , yycolumn, yyline, yytext());
          }
        case 81: break;
        case 1: 
          { /*Ignore*/
          }
        case 82: break;
        case 7: 
          { System.out.println("PUNT COMA: "+yytext()); return new Symbol(Simbolos.PUNTO_COMA , yycolumn, yyline, yytext());
          }
        case 83: break;
        case 22: 
          { System.out.println("LLAVES_A: "+yytext()); return new Symbol(Simbolos.LLAVES_A , yycolumn, yyline, yytext());
          }
        case 84: break;
        case 27: 
          { System.out.println("COMENTARIO_C: "+yytext()); return new Symbol(Simbolos.COMENTARIO_C , yycolumn, yyline, yytext());
          }
        case 85: break;
        case 41: 
          { System.out.println("EXTENSION: "+yytext()); return new Symbol(Simbolos.EXTENSION , yycolumn, yyline, yytext());
          }
        case 86: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(Simbolos.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
