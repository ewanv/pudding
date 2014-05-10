package uts.wsd.soap.client;

public class ArticlesSOAPProxy implements uts.wsd.soap.client.ArticlesSOAP {
  private String _endpoint = null;
  private uts.wsd.soap.client.ArticlesSOAP articlesSOAP = null;
  
  public ArticlesSOAPProxy() {
    _initArticlesSOAPProxy();
  }
  
  public ArticlesSOAPProxy(String endpoint) {
    _endpoint = endpoint;
    _initArticlesSOAPProxy();
  }
  
  private void _initArticlesSOAPProxy() {
    try {
      articlesSOAP = (new uts.wsd.soap.client.ArticlesSOAPServiceLocator()).getArticlesSOAPPort();
      if (articlesSOAP != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)articlesSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)articlesSOAP)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (articlesSOAP != null)
      ((javax.xml.rpc.Stub)articlesSOAP)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uts.wsd.soap.client.ArticlesSOAP getArticlesSOAP() {
    if (articlesSOAP == null)
      _initArticlesSOAPProxy();
    return articlesSOAP;
  }
  
  public void deleteArticle(long arg0) throws java.rmi.RemoteException{
    if (articlesSOAP == null)
      _initArticlesSOAPProxy();
    articlesSOAP.deleteArticle(arg0);
  }
  
  public uts.wsd.soap.client.Article[] fetchArticles() throws java.rmi.RemoteException{
    if (articlesSOAP == null)
      _initArticlesSOAPProxy();
    return articlesSOAP.fetchArticles();
  }
  
  
}