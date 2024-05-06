



<div class="TaskDescription__StandardTaskDescription-sc-7m9k5q-3 kHwARi"><h2 class="mod-hidden">Task description</h2><div class="TaskDescription__TaskContentWrapper-sc-7m9k5q-2 task-description-content"><p>You are writing a service that manages a collection of articles. Your task is to create a class called <code>CachedArticlesService<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> which adds a caching layer over the database access.</p>
<p><code>CachedArticlesService<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> needs to implement the following interface:</p>
<pre class="CopyableCodeElements__StyledPre-sc-1mdtehs-0 dhpwcq"><code>package com.codility.caching;

public interface ArticlesService {
Article getArticle(Long articleId);

    void removeArticle(Long articleId);

    void saveArticle(Article article);

    Article updateLikes(Long articleId, int likes);
}
</code><div><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></div></pre>
<p>You are also given a class that provides the integration with the database. You can find its interface below:</p>
<pre class="CopyableCodeElements__StyledPre-sc-1mdtehs-0 dhpwcq"><code>package com.codility.caching;

public interface ArticlesRepository {
void save(Article article);

    Article get(Long articleId);

    void remove(Long articleId);

    Article updateLikes(Long articleId, int likes);
}
</code><div><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></div></pre>
<p>Lastly, an article is represented by the following class:</p>
<pre class="CopyableCodeElements__StyledPre-sc-1mdtehs-0 dhpwcq"><code>package com.codility.caching;

class Article {
private Long articleId;
private String contents;
private int likes;
}
</code><div><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></div></pre>
<p>You may assume that all getters and setters are also implemented.</p>
<h1>Requirements</h1>
<ol>
<li>
<p>Implement the methods in <code>CachedArticlesService<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> class.</p>
</li>
<li>
<p>You can use just one cache, which is called <code>articles<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code>. Keys in this cache are always article ids.</p>
</li>
<li>
<p>Each <code>ArticlesService<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> method has different requirements:</p>
<ul>
<li><code>getArticle<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code>:
<ul>
<li>should call the <code>ArticlesRepository.get<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> method;</li>
<li>should put the article with a given <code>articleId<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> in the cache;</li>
<li>should <b>not</b> call <code>ArticlesRepository.get<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> and <b>not</b> put the article in the cache if the given <code>articleId<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> is already in the cache.</li>
</ul>
</li>
<li><code>removeArticle<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code>:
<ul>
<li>should call the <code>ArticlesRepository.remove<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> method;</li>
<li>should remove the article with a given <code>articleId<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> from the cache.</li>
</ul>
</li>
<li><code>saveArticle<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code>:
<ul>
<li>should call the <code>ArticlesRepository.save<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> method;</li>
<li>should <b>not</b> put the article in the cache.</li>
</ul>
</li>
<li><code>updateLikes<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code>:
<ul>
<li>should call the <code>ArticlesRepository.updateLikes<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> method;</li>
<li>should update the article with a given <code>articleId<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> in the cache.</li>
</ul>
</li>
</ul>
</li>
<li>
<p>You are working with Spring Framework 5.1.5 and Java 8.
Your Spring context is already populated with the following beans:</p>
<ul>
<li><code>com.codility.caching.ArticlesRepository<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code></li>
<li><code>org.springframework.cache.CacheManager<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code></li>
</ul>
</li>
<li>
<p>You are expected to use annotations and <code>CacheManager<span><button class="sc-jSMfEi irFEjw rondo-Typography__root sc-ftvSup gavPPr rondo-Button__root ghost-variant start-icon compact icon CopyableCodeElements__InlineCopyRondoButton-sc-1mdtehs-1 crZcmy basic" type="button" data-analytics-id="task-description:copy-button"><div class="rondo-Button__content-container"><div class="sc-papXJ bYSwmX rondo-Button__icon-wrapper"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24"><g fill="none" fill-rule="evenodd"><path d="M0 0h24v24H0z"></path><path fill="currentColor" d="M15.117 2H5.29C4.305 2 3.5 2.818 3.5 3.818v11.833a.895.895 0 0 0 1.79 0V3.818h9.827a.91.91 0 0 0 0-1.818m3.594 3.636H8.868c-.984 0-1.79.819-1.79 1.819v12.727c0 1 .806 1.818 1.79 1.818h9.843c.984 0 1.789-.818 1.789-1.818V7.455c0-1-.805-1.819-1.79-1.819m-1 14.546H9.868a1 1 0 0 1-1-1V8.455a1 1 0 0 1 1-1h7.843a1 1 0 0 1 1 1v10.727a1 1 0 0 1-1 1"></path></g></svg></div></div></button></span></code> from the Spring Framework.</p>
</li>
</ol>

<div style="margin-top: 5px;">
<small>
Copyright 2009–2024 by Codility Limited.
All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
</small>
</div></div></div>