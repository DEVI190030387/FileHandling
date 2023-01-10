	package filehandling;
	import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
	public class FileSeperation {
	
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			String path ="C:\\Files\\";
			String filenames[] = {"text1.txt","text2.txt","text3.txt","audio1.mp3","audio2.mp3","video1.mp4","video2.mp4","pdf1.pdf"};
			String foldernames[] = {"Audios","Documents","Videos"};
			String text;
			path=path+"report.txt";
			File report = new File(path);
			report.createNewFile();
			for(String i:foldernames) {
				String str=i;
				path ="C:\\Files\\";
				path =path.concat(str);
				File f1=new File(path);
				 boolean bool = f1.mkdir(); 
				 if(bool){  
			         System.out.println("Folder is created successfully");  
			      }else{  
			         System.out.println("Error Found!");  
			      }  
				
			}
			for(String i:filenames) {
				String str=i;
				path ="C:\\Files\\";
				path = path.concat(str);
				File file = new File(path);
				try {
					if (file.createNewFile())
					{ 
						System.out.println("File is created!"); 
						}
					else{ 
						System.out.println("File already exists.");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			
			for(String str:filenames) {
				String arr[]=new String[] {".txt",".pdf"};
				for(String i:arr) {
				if(str.contains(i)) {
					try {
						Path temp = Files.move
						        (Paths.get("C:\\Files\\"+str),
						        Paths.get("C:\\Files\\Documents\\"+str));
						if(temp != null)
				        {
				            System.out.println("File moved successfully to Documents");
				            FileWriter fw = new FileWriter("C:\\Files\\report.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
						    try (PrintWriter out = new PrintWriter(bw)) {
								out.println("File name : text file "+str);
								out.println("File type : "+i);
								out.println("Assigned folder name : Documents");
							}
				        }
				        else
				        {
				            System.out.println("Failed to move the file");
				        }
					}
					
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
				}
				
				else if(str.contains(".mp3")) {
				try {
					Path temp = Files.move
					        (Paths.get("C:\\Files\\"+str),
					        Paths.get("C:\\Files\\Audios\\"+str));
					if(temp != null)
			        {
			            System.out.println("File moved successfully to Audios");
			            FileWriter fw = new FileWriter("C:\\Files\\report.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
					    try (PrintWriter out = new PrintWriter(bw)) {
							out.println("File name : "+str);
							out.println("File type : .mp3");
							out.println("Assigned folder name : Audios");
						}
			            
			        }
			        else
			        {
			            System.out.println("Failed to move the file");
			        }
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
			}
				else if(str.contains(".mp4")) {
					try {
						Path temp = Files.move
						        (Paths.get("C:\\Files\\"+str),
						        Paths.get("C:\\Files\\Videos\\"+str));
						if(temp != null)
				        {
				            System.out.println("File moved successfully to Videos");
				            FileWriter fw = new FileWriter("C:\\Files\\report.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
						    try (PrintWriter out = new PrintWriter(bw)) {
								out.println("File name : "+str);
								out.println("File type : .mp4");
								out.println("Assigned folder name : Videos");
							}
				            
				        }
				        else
				        {
				            System.out.println("Failed to move the file");
				        }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
				}
			
			}}
		}
	}

	
