function VaildURL(a){return(/^(https?:\/\/)?[\w\-.]+\.(qq|paipai|soso|taotao)\.com($|\/|\\)/i).test(a)||(/^[\w][\w\/\.\-_%]+$/i).test(a)||(/^[\/\\][^\/\\]/i).test(a)?true:false}function HtmlEncode(a){a=a.replace(/&/g,"&amp;");a=a.replace(/>/g,"&gt;");a=a.replace(/</g,"&lt;");a=a.replace(/"/g,"&quot;");a=a.replace(/'/g,"&#39;");return a}function HtmlUnEncode(a){a=a.replace(/&amp;/g,"&");a=a.replace(/&gt;/g,">");a=a.replace(/&lt;/g,"<");a=a.replace(/&quot;/g,'"');a=a.replace(/&#39;/g,"'");return a}function HtmlAttributeEncode(a){a=a.replace(/&/g,"&amp;");a=a.replace(/>/g,"&gt;");a=a.replace(/</g,"&lt;");a=a.replace(/"/g,"&quot;");a=a.replace(/'/g,"&#39;");a=a.replace(/=/g,"&#61;");a=a.replace(/`/g,"&#96;");return a}function UriComponentEncode(a){a=encodeURIComponent(a);a=a.replace(/~/g,"%7E");a=a.replace(/!/g,"%21");a=a.replace(/\*/g,"%2A");a=a.replace(/\(/g,"%28");a=a.replace(/\)/g,"%29");a=a.replace(/'/g,"%27");a=a.replace(/\?/g,"%3F");a=a.replace(/;/g,"%3B");return a}String.prototype.escHtmlEp=function(){return this.replace(/[&'"<>\/\\\-\x00-\x1f\x80-\xff]/g,function(a){return"&#"+a.charCodeAt(0)+";"})};String.prototype.escHtml=function(){return this.replace(/[&'"<>\/\\\-\x00-\x09\x0b-\x0c\x1f\x80-\xff]/g,function(a){return"&#"+a.charCodeAt(0)+";"}).replace(/\r\n/g,"<BR>").replace(/\n/g,"<BR>").replace(/\r/g,"<BR>").replace(/ /g,"&nbsp;")};String.prototype.escScript=function(){return this.replace(/[\\"']/g,function(a){return"\\"+a}).replace(/%/g,"\\x25").replace(/\n/g,"\\n").replace(/\r/g,"\\r").replace(/\x01/g,"\\x01")};String.prototype.escUrl=function(){return escape(this).replace(/\+/g,"%2B")};String.prototype.escHrefScript=function(){return this.escScript().escMiniUrl().escHtmlEp()};String.prototype.escRegexp=function(){return this.replace(/[\\\^\$\*\+\?\{\}\.\(\)\[\]]/g,function(d,c){return"\\"+d})};