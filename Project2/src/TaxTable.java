
public class TaxTable {
	public static void main(String[] args) {
			
		drawTable();
	}
	static double ScheduleX(double income){
		/**
		 * 返回由Schedule X — Single得到的税值
		 * @param income double 收入
		 * @return tax double 应交的税
		 */
		double tax = 0;//保存算出的税值
		int n = ((income<0)==true?1:0)
				+((income<=7300)==true?1:0)
				+((income<=29700)==true?1:0)
				+((income<=71950)==true?1:0)
				+((income<=150150)==true?1:0)
				+((income<=326450)==true?1:0);
		// n为5是为第一档
		// n为4是为第二档
		// n为3是为第三档
		// n为2是为第四档
		// n为1是为第五档
		// n为0是为第六档
		switch(n) {
		case 0:
			tax=94727.50+(income-326450)*0.35;
			break;
		case 1:
			tax=36548.50+(income-150150)*0.33;
			break;
		case 2:
			tax=14652.50+(income-71950)*0.28;
			break;
		case 3:
			tax=4090.00+(income-29700)*0.25;
			break;
		case 4:
			tax=730+(income-7300)*0.15;
			break;
		case 5:
			tax=income*0.1;
			break;
		case 6:
			System.out.println("X变量不能为负");
			break;
		default:
			System.out.println("X变量异常");
			break;
				
		}//根据不同的收入阶层，用不同的公式计算税
		return tax;
	}
	
	static double ScheduleY1(double income){
		/**
		 * 返回由Schedule Y-1 — Married Filing Jointly or Qualifying Widow得到的税值
		 * @param income double 收入
		 * @return tax double 应交的税
		 */
		double tax = 0;//保存算出的税值
		int n = ((income<0)==true?1:0)
				+((income<=14600)==true?1:0)
				+((income<=59400)==true?1:0)
				+((income<=119950)==true?1:0)
				+((income<=182800)==true?1:0)
				+((income<=326450)==true?1:0);
		// n为5是为第一档
		// n为4是为第二档
		// n为3是为第三档
		// n为2是为第四档
		// n为1是为第五档
		// n为0是为第六档
		switch(n) {
		case 0:
			tax=88320.00+(income-326450)*0.35;
			break;
		case 1:
			tax=40915.50+(income-182800)*0.33;
			break;
		case 2:
			tax=23317.50+(income-119950)*0.28;
			break;
		case 3:
			tax=8180+(income-59400)*0.25;
			break;
		case 4:
			tax=1460.00+(income-14600)*0.15;
			break;
		case 5:
			tax=income*0.1;
			break;
		case 6:
			System.out.println("Y1变量不能为负");
			break;
		default:
			System.out.println("Y1变量异常");
			break;	
		}//根据不同的收入阶层，用不同的公式计算税
		return tax;
	}

	static double ScheduleY2(double income){
		/**
		 * 返回由Schedule Y-2 — Married Filing Separately得到的税值
		 * @param income double 收入
		 * @return tax double 应交的税
		 */
		double tax = 0;//保存算出的税值
		int n = ((income<0)==true?1:0)
				+((income<=7300)==true?1:0)
				+((income<=29700)==true?1:0)
				+((income<=59975)==true?1:0)
				+((income<=91400)==true?1:0)
				+((income<=163225)==true?1:0);
		// n为5是为第一档
		// n为4是为第二档
		// n为3是为第三档
		// n为2是为第四档
		// n为1是为第五档
		// n为0是为第六档
		switch(n) {
		case 0:
			tax=44160.00+(income-163225)*0.35;
			break;
		case 1:
			tax=20457.75+(income-91400)*0.33;
			break;
		case 2:
			tax=11658.75+(income-59975)*0.28;
			break;
		case 3:
			tax=4090+(income-29700)*0.25;
			break;
		case 4:
			tax=730+(income-7300)*0.15;
			break;
		case 5:
			tax=income*0.1;
			break;
		case 6:
			System.out.println("Y2变量不能为负");
			break;
		default:
			System.out.println("Y2变量异常");
			break;
				
		}//根据不同的收入阶层，用不同的公式计算税
		return tax;
	}
	
	static double ScheduleZ(double income){
		/**
		 * 返回由Schedule Z — Head of Household得到的税值
		 * @param income double 收入
		 * @return tax double 应交的税
		 */
		double tax = 0;//保存算出的税值
		int n = ((income<0)==true?1:0)
				+((income<=10450)==true?1:0)
				+((income<=39800)==true?1:0)
				+((income<=102800)==true?1:0)
				+((income<=166450)==true?1:0)
				+((income<=326450)==true?1:0);
		// n为5是为第一档
		// n为4是为第二档
		// n为3是为第三档
		// n为2是为第四档
		// n为1是为第五档
		// n为0是为第六档
		switch(n) {
		case 0:
			tax=91819.50+(income-326450)*0.35;
			break;
		case 1:
			tax=39019.50+(income-166450)*0.33;
			break;
		case 2:
			tax=21197.50+(income-102800)*0.28;
			break;
		case 3:
			tax=5447.50+(income-39800)*0.25;
			break;
		case 4:
			tax=1045+(income-10450)*0.15;
			break;
		case 5:
			tax=income*0.1;
			break;
		case 6:
			System.out.println("Z变量不能为负");
			break;
		default:
			System.out.println("Z变量异常");
			break;
				
		}//根据不同的收入阶层，用不同的公式计算税
		return tax;
	}

	static void drawTable() {
		/**
		 * 打印50000到60000收入不同类型的人的应缴税额表
		 */
		System.out.printf("taxable   Single    Married   Married   Head of   \n");
		System.out.printf("Income              Joint     Separate  a House   \n");
		System.out.println("");
		for(double income=50000;income<=60000;income+=50) {
			//循环打印50000~60000的数据
		System.out.printf("%-,10.0f%-,10.1f%-,10.1f%-,10.1f%-,10.1f\n", income,ScheduleX(income),ScheduleY1(income),ScheduleY2(income),ScheduleZ(income));
		}
	}
}
