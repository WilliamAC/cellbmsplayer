package com.g2d.display.ui.text;

import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Hashtable;

import com.cell.util.EnumManager.ValueEnum;

public enum Instruction implements ValueEnum<String>
{
	/** [color:color as AARRGGBB]text[color] */
	COLOR			("color",	TextAttribute.FOREGROUND),

	/** [back:color as AARRGGBB]text[back] */
	BACK_COLOR		("back",	TextAttribute.BACKGROUND),
	
	/** [size:font_size]text[size] */
	SIZE			("size",	TextAttribute.SIZE),

	/** [bold]text[bold] */
	BOLD			("bold",	TextAttribute.WEIGHT),
	
	/** [font:font name@style@size]text[font] <br> 
	 * @see java.awt.Font*/
	FONT			("font",	TextAttribute.FONT),
	
	/** [under]text[under] */
	UNDERLINE		("under",	TextAttribute.UNDERLINE),
	
	/** [link:text or url]text[link] */
	LINK			("link",	com.g2d.display.ui.text.TextAttribute.LINK),
	
	/** [anti:1 or 0]text[anti] */
	ANTIALIASING	("anti",	com.g2d.display.ui.text.TextAttribute.ANTIALIASING),

	/** [image:path]replacement[image]<br>
	 * 其中的文字将用图片填充*/
	IMAGE			("image",	TextAttribute.CHAR_REPLACEMENT),
	
	/** [sprite:path@sprite name@animate]replacement[sprite]<br>
	 * 其中的文字将用精灵填充*/
	SPRITE			("sprite",	TextAttribute.CHAR_REPLACEMENT),
	;

	final public String		value;
	final public Attribute	attribute;
	
	Instruction(String v, Attribute attr) {
		value = v;
		attribute = attr;
	}
	
	public String getValue() {
		return value;
	}
	
	private static Hashtable<String, Instruction> instractions = null;

	static public Instruction getInstraction(String string)
	{
		if (instractions == null) {
			instractions = new Hashtable<String, Instruction>();
			for (Instruction ins : Instruction.values()) {
				instractions.put(ins.value, ins);
			}
		}
		return instractions.get(string);
	}
}
