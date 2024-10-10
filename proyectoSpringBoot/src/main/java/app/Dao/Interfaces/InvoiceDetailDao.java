package app.Dao.Interfaces;

import app.Dto.InvoiceDetailDto;


public interface InvoiceDetailDao {
  public  void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
  public  InvoiceDetailDto findInvoiceDetailById(InvoiceDetailDto invoiceDetailDto) throws Exception;
  public void updateInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
  public void deleteInvoiceDetail(InvoiceDetailDto invoiceDetailDto) throws Exception;
    
}
