package org.yoqu.common.entity.rule;

import org.hsweb.web.bean.po.GenericPo;
/**
 * Created by Kai on 2017/6/9.
 *
 * @Email zack.zhong@qq.com
 */
public class StoryRulePo extends BaseRulePo {

	private String bookName;

	private String authorName;

	private String type;

	private String listRule;

	private String chapterName;

	private String url;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getListRule() {
		return listRule;
	}

	public void setListRule(String listRule) {
		this.listRule = listRule;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public interface Property extends GenericPo.Property{
		String bookName = "bookName";

		String authorName = "authorName";

		String type = "type";

		String listRule = "listRule";

		String chapterName = "chapterName";

		String url = "url";
	}

}
